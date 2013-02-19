USE monarca;

INSERT INTO project(id, description, createdOn) VALUES (1,'monarca1','2013-02-01');
INSERT INTO project(id, description, createdOn) VALUES (2,'monarca2','2013-02-02');
INSERT INTO project(id, description, createdOn) VALUES (3,'Galileo','2013-02-02');

INSERT INTO branch(id, description, createdOn, project) VALUES (1,'branch1','2013-02-03', 1);
INSERT INTO branch(id, description, createdOn, project) VALUES (2,'branch2','2013-02-03', 2);
INSERT INTO branch(id, description, createdOn, project) VALUES (3,'trunk','2013-02-03', 3);

INSERT INTO build(id, description, version, branch) VALUES (1,'build1','2013-03-02', 1);
INSERT INTO build(id, description, version, branch) VALUES (2,'build2','2013-03-04', 1);
INSERT INTO build(id, description, version, branch) VALUES (3,'build3','2013-03-05', 1);

INSERT INTO build(id, description, version, branch) VALUES (4,'build4','2013-03-07', 2);
INSERT INTO build(id, description, version, branch) VALUES (5,'build5','2013-03-08', 2);
INSERT INTO build(id, description, version, branch) VALUES (6,'build6','2013-03-09', 2);

INSERT INTO build(id, description, version, branch) VALUES (7,'23','2013-03-05', 3);

insert into role (id, roleName)values (1,"ROLE_projectManager");
insert into role (id, roleName)values (2,"ROLE_tester");
insert into role (id, roleName )values (3,"ROLE_developer");
insert into role (id, roleName )values (4,"ROLE_listener");

insert into user (id, userName,password)values (1,"baeza",sha("baeza"));
insert into user (id, userName,password)values (2,"ronald",sha("ronald"));
insert into user (id, userName,password)values (3,"tavo",sha("tavo"));
insert into user (id, userName,password)values (4,"guillen",sha("guillen"));
insert into user (id, userName,password)values (5,"listener",sha("monarcaListener"));

insert into userRole(user,role) values (1,3);
insert into userRole(user,role) values (2,3);
insert into userRole(user,role) values (3,2);
insert into userRole(user,role) values (4,1);
insert into userRole(user,role) values (4,3);
insert into userRole(user,role) values (5,4);

insert into topic(id,topicName,topicKey) values (1,"Dead code","DeadCode");
insert into topic(id,topicName,topicKey) values (2,"Coverage","Coverage");
insert into topic(id,topicName,topicKey) values (3,"Working on this","WorkingOn");

insert into activity(id,activityName,topic,role) values (1,"Add",1,3);
insert into activity(id,activityName,topic,role) values (2,"remove",1,3);
insert into activity(id,activityName,topic,role) values (3,"Edit",1,2);
insert into activity(id,activityName,topic,role) values (4,"Clear",3,1);