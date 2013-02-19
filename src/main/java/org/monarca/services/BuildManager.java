package org.monarca.services;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import morphos.collector.Digest;
import morphos.util.FileCopyUtils;

import org.monarca.configuration.Enviroment;
import org.monarca.dao.JPABranchDao;
import org.monarca.dao.JPABuildDao;
import org.monarca.dao.JPAProjectDao;
import org.monarca.entities.Branch;
import org.monarca.entities.Build;
import org.monarca.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import converter._Constructor;

@Service
@Transactional
public class BuildManager {

    private static final long serialVersionUID = 1L;

    @Autowired
    private JPABuildDao buildDao;
    
    @Autowired
    private JPAProjectDao projectDao;
    
    @Autowired
    private JPABranchDao branchDao;
    
    private Enviroment enviroment;

    public List<Build> getBuilds() {
        return buildDao.getBuildList();
    }
  
	public List<Build> getBuildByBranchDescription(String description) {
		return buildDao.getBuildByBranchDescription(description);
	}

	public boolean save(Build build){
		return buildDao.save(build);
	}
    
	public void createBuild(Build build) throws Exception {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String workSpace = enviroment.getWorkSpace()+build.getBranch().getProject().getDescription()+File.separator+build.getBranch().getDescription()+File.separator+build.getDescription()+File.separator;
		String landingZone = enviroment.getLandingZone();
		String sourcesDirectory = workSpace+ enviroment.getSource();
		String temporalDirectory = workSpace+ enviroment.getTemporal();
		String outputs = workSpace+enviroment.getInstrumentation();
		String repoName = enviroment.getRepoName();
		//TODO String fileName = buildName+buildVersion+".mrf"; // nombre con fecha y hora alrevez ticket 544
		
		File sourcesFileDirectory = new File(landingZone);
		File sourcesFiletarget = new File(sourcesDirectory);
		File sourcesFileTemporal = new File(temporalDirectory);
		sourcesFiletarget.mkdirs();
		sourcesFileTemporal.mkdirs();
		FileCopyUtils.copyFilesRecusively(sourcesFileDirectory, sourcesFiletarget);
		
		//TODO limpiar landingzone
			
		Project project = projectDao.getProjectByDescription(build.getBranch().getProject().getDescription()); 
		Branch brache =  branchDao.getBranchByDescription(build.getBranch().getDescription());
		brache.setProject(project);
		build.setBranch(brache);
		build.setVersion(dateFormat.format(new Date()));
		
		Digest collector = new Digest(sourcesDirectory, temporalDirectory, workSpace, repoName);
		collector.digestSourceFiles();
		
		String args[] = new String[]{workSpace+File.separator+repoName+".mrf"};
		_Constructor constructor = new _Constructor(args);
		//TODO constructor.fileName = fileName;
		constructor.targetDirectory = workSpace;
		constructor.outputDirectory = outputs;
		constructor.execute();		

		//TODO Si esta en modo debug tengo que prettyprintiar a tavo todo el repo. Esto va en el contruir mml. ticket 545
		
		buildDao.save(build);	
		
		//TODO Llamar al comparar, ir al workspace y guardar archivoDiferencias, poniendole un nombre adecuado que son las diferencias entre build viejo y nuevo. ticket 546
		//archivoDiferencias = comparara (nombreBuildaAnterior, fileName);
		//TODO Copiar los archivos instrumentados al landingZone ticket 547
	}
	
	@Autowired
	public void setEnviroment(Enviroment enviroment)
	{
		this.enviroment =enviroment;
	}
	
}