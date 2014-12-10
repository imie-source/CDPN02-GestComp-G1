CREATE TABLE public.PERSON(
    id_person              SERIAL NOT NULL ,
    name                   VARCHAR (80)  ,
    login                  VARCHAR (50)  ,
    pswd                   VARCHAR (50)  ,
    email                  VARCHAR (80)  ,
    phone                  VARCHAR (12)  ,
    description            VARCHAR (2000)   ,
    available              BOOL   ,
    id_promotion_PROMOTION INT   ,
    CONSTRAINT prk_constraint_PERSON PRIMARY KEY (id_person)
)WITHOUT OIDS;

CREATE TABLE public.SKILL(
    id_skill   SERIAL NOT NULL ,
    name_skill VARCHAR (128)  ,
    id_skill1  INT   ,
    CONSTRAINT prk_constraint_SKILL PRIMARY KEY (id_skill)
)WITHOUT OIDS;

CREATE TABLE public.PROJECT(
    id_projet        SERIAL NOT NULL ,
    title            VARCHAR (128)  ,
    id_person_PERSON INT  NOT NULL ,
    CONSTRAINT prk_constraint_PROJECT PRIMARY KEY (id_projet)
)WITHOUT OIDS;

CREATE TABLE public.PROMOTION(
    id_promotion SERIAL NOT NULL ,
    name         VARCHAR (80)  ,
    date         DATE   ,
    CONSTRAINT prk_constraint_PROMOTION PRIMARY KEY (id_promotion)
)WITHOUT OIDS;

CREATE TABLE public.PROFILE(
    id_profile  SERIAL NOT NULL ,
    name        VARCHAR (80)  ,
    id_profile1 INT   ,
    CONSTRAINT prk_constraint_PROFILE PRIMARY KEY (id_profile)
)WITHOUT OIDS;

CREATE TABLE public.FONCTION(
    id_fonction SERIAL NOT NULL ,
    name        VARCHAR (25)  ,
    CONSTRAINT prk_constraint_FONCTION PRIMARY KEY (id_fonction)
)WITHOUT OIDS;

CREATE TABLE public.PERMISSION(
    id_permission   SERIAL NOT NULL ,
    name_permission VARCHAR (25)  ,
    CONSTRAINT prk_constraint_PERMISSION PRIMARY KEY (id_permission)
)WITHOUT OIDS;

CREATE TABLE public.NOTIFICATION(
    id_notification SERIAL NOT NULL ,
    date            DATE  NOT NULL ,
    content         VARCHAR (2000)  NOT NULL ,
    CONSTRAINT prk_constraint_NOTIFICATION PRIMARY KEY (id_notification)
)WITHOUT OIDS;

CREATE TABLE public.TASK(
    id_task            SERIAL NOT NULL ,
    title              VARCHAR (80)  ,
    estimated_duration TIMESTAMPTZ  ,
    status             INT   ,
    id_projet_PROJECT  INT   ,
    CONSTRAINT prk_constraint_TASK PRIMARY KEY (id_task)
)WITHOUT OIDS;

CREATE TABLE public.SKILL_PERSON_ASSOC(
    level_skill      VARCHAR (25)  ,
    id_person_PERSON INT  NOT NULL ,
    id_skill_SKILL   INT  NOT NULL ,
    CONSTRAINT prk_constraint_SKILL_PERSON_ASSOC PRIMARY KEY (id_person_PERSON,id_skill_SKILL)
)WITHOUT OIDS;

CREATE TABLE public.PROJECT_PERSON_ASSOC(
    id_person_PERSON  INT  NOT NULL ,
    id_projet_PROJECT INT  NOT NULL ,
    CONSTRAINT prk_constraint_PROJECT_PERSON_ASSOC PRIMARY KEY (id_person_PERSON,id_projet_PROJECT)
)WITHOUT OIDS;

CREATE TABLE public.PERSON_PROFILE_ASSOC(
    id_person_PERSON   INT  NOT NULL ,
    id_profile_PROFILE INT  NOT NULL ,
    CONSTRAINT prk_constraint_PERSON_PROFILE_ASSOC PRIMARY KEY (id_person_PERSON,id_profile_PROFILE)
)WITHOUT OIDS;

CREATE TABLE public.RIGHTS_ASSOC(
    id_profile_PROFILE       INT  NOT NULL ,
    id_fonction_FONCTION     INT  NOT NULL ,
    id_permission_PERMISSION INT  NOT NULL ,
    CONSTRAINT prk_constraint_RIGHTS_ASSOC PRIMARY KEY (id_profile_PROFILE,id_fonction_FONCTION,id_permission_PERMISSION)
)WITHOUT OIDS;

CREATE TABLE public.PERSON_NOTIF_ASSOC(
    id_notification_NOTIFICATION INT  NOT NULL ,
    id_person_PERSON             INT  NOT NULL ,
    CONSTRAINT prk_constraint_PERSON_NOTIF_ASSOC PRIMARY KEY (id_notification_NOTIFICATION,id_person_PERSON)
)WITHOUT OIDS;

CREATE TABLE public.SKILL_TASK_ASSOC(
    id_task_TASK   INT  NOT NULL ,
    id_skill_SKILL INT  NOT NULL ,
    CONSTRAINT prk_constraint_SKILL_TASK_ASSOC PRIMARY KEY (id_task_TASK,id_skill_SKILL)
)WITHOUT OIDS;



ALTER TABLE public.PERSON ADD CONSTRAINT FK_PERSON_id_promotion_PROMOTION FOREIGN KEY (id_promotion_PROMOTION) REFERENCES public.PROMOTION(id_promotion);
ALTER TABLE public.SKILL ADD CONSTRAINT FK_SKILL_id_skill1 FOREIGN KEY (id_skill1) REFERENCES public.SKILL(id_skill);
ALTER TABLE public.PROJECT ADD CONSTRAINT FK_PROJECT_id_person_PERSON FOREIGN KEY (id_person_PERSON) REFERENCES public.PERSON(id_person);
ALTER TABLE public.PROFILE ADD CONSTRAINT FK_PROFILE_id_profile1 FOREIGN KEY (id_profile1) REFERENCES public.PROFILE(id_profile);
ALTER TABLE public.TASK ADD CONSTRAINT FK_TASK_id_projet_PROJECT FOREIGN KEY (id_projet_PROJECT) REFERENCES public.PROJECT(id_projet);
ALTER TABLE public.SKILL_PERSON_ASSOC ADD CONSTRAINT FK_SKILL_PERSON_ASSOC_id_person_PERSON FOREIGN KEY (id_person_PERSON) REFERENCES public.PERSON(id_person);
ALTER TABLE public.SKILL_PERSON_ASSOC ADD CONSTRAINT FK_SKILL_PERSON_ASSOC_id_skill_SKILL FOREIGN KEY (id_skill_SKILL) REFERENCES public.SKILL(id_skill);
ALTER TABLE public.PROJECT_PERSON_ASSOC ADD CONSTRAINT FK_PROJECT_PERSON_ASSOC_id_person_PERSON FOREIGN KEY (id_person_PERSON) REFERENCES public.PERSON(id_person);
ALTER TABLE public.PROJECT_PERSON_ASSOC ADD CONSTRAINT FK_PROJECT_PERSON_ASSOC_id_projet_PROJECT FOREIGN KEY (id_projet_PROJECT) REFERENCES public.PROJECT(id_projet);
ALTER TABLE public.PERSON_PROFILE_ASSOC ADD CONSTRAINT FK_PERSON_PROFILE_ASSOC_id_person_PERSON FOREIGN KEY (id_person_PERSON) REFERENCES public.PERSON(id_person);
ALTER TABLE public.PERSON_PROFILE_ASSOC ADD CONSTRAINT FK_PERSON_PROFILE_ASSOC_id_profile_PROFILE FOREIGN KEY (id_profile_PROFILE) REFERENCES public.PROFILE(id_profile);
ALTER TABLE public.RIGHTS_ASSOC ADD CONSTRAINT FK_RIGHTS_ASSOC_id_profile_PROFILE FOREIGN KEY (id_profile_PROFILE) REFERENCES public.PROFILE(id_profile);
ALTER TABLE public.RIGHTS_ASSOC ADD CONSTRAINT FK_RIGHTS_ASSOC_id_fonction_FONCTION FOREIGN KEY (id_fonction_FONCTION) REFERENCES public.FONCTION(id_fonction);
ALTER TABLE public.RIGHTS_ASSOC ADD CONSTRAINT FK_RIGHTS_ASSOC_id_permission_PERMISSION FOREIGN KEY (id_permission_PERMISSION) REFERENCES public.PERMISSION(id_permission);
ALTER TABLE public.PERSON_NOTIF_ASSOC ADD CONSTRAINT FK_PERSON_NOTIF_ASSOC_id_notification_NOTIFICATION FOREIGN KEY (id_notification_NOTIFICATION) REFERENCES public.NOTIFICATION(id_notification);
ALTER TABLE public.PERSON_NOTIF_ASSOC ADD CONSTRAINT FK_PERSON_NOTIF_ASSOC_id_person_PERSON FOREIGN KEY (id_person_PERSON) REFERENCES public.PERSON(id_person);
ALTER TABLE public.SKILL_TASK_ASSOC ADD CONSTRAINT FK_SKILL_TASK_ASSOC_id_task_TASK FOREIGN KEY (id_task_TASK) REFERENCES public.TASK(id_task);
ALTER TABLE public.SKILL_TASK_ASSOC ADD CONSTRAINT FK_SKILL_TASK_ASSOC_id_skill_SKILL FOREIGN KEY (id_skill_SKILL) REFERENCES public.SKILL(id_skill);
