package org.monarca.configuration;

import java.io.IOException;

import monarca.listener.Listener;

public class Enviroment {
	
	private String workSpace;
	private String landingZone;
	private String repoName;
	private String queueUrl;
	private String source;
	private String temporal;
	private String instrumentation;
	private String prettyPrinter;
	private String listenerHost;
	private String listenerContext;
	private int listenerPort;

	public void init()
	{
		System.out.println("Starting Listener");
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				
				
				try {
					new Listener(listenerHost, listenerPort, listenerContext);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		System.out.println("Listener Started");
	
	}
	
	public String getWorkSpace() {
		return workSpace;
	}
	public void setWorkSpace(String workSpace) {
		this.workSpace = workSpace;
	}
	public String getLandingZone() {
		return landingZone;
	}
	public void setLandingZone(String landingZone) {
		this.landingZone = landingZone;
	}
	public String getRepoName() {
		return repoName;
	}
	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}
	public String getQueueUrl() {
		return queueUrl;
	}
	public void setQueueUrl(String queueUrl) {
		this.queueUrl = queueUrl;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTemporal() {
		return temporal;
	}
	public void setTemporal(String temporal) {
		this.temporal = temporal;
	}
	public String getInstrumentation() {
		return instrumentation;
	}
	public void setInstrumentation(String instrumentation) {
		this.instrumentation = instrumentation;
	}
	public String getPrettyPrinter() {
		return prettyPrinter;
	}
	public void setPrettyPrinter(String prettyPrinter) {
		this.prettyPrinter = prettyPrinter;
	}

	public String getListenerHost() {
		return listenerHost;
	}

	public void setListenerHost(String listenerHost) {
		this.listenerHost = listenerHost;
	}

	public String getListenerContext() {
		return listenerContext;
	}

	public void setListenerContext(String listenerContext) {
		this.listenerContext = listenerContext;
	}

	public int getListenerPort() {
		return listenerPort;
	}

	public void setListenerPort(int listenerPort) {
		this.listenerPort = listenerPort;
	}

	
	
	
}
