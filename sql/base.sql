CREATE TABLE joueurs(
      id  SERIAL PRIMARY KEY,
      nom varchar,
      prenom varchar,
      taille int ,
      attaquant int ,
      milieu int,
      defenseur int,
      gardien int ,
      nationalite  int references  nationalite,
      club int references club,
      physique int ,
      vitesse int,
      passe int ,
      tir int ,
      dribble int ,
      defense int
);


CREATE TABLE poste(
       id  SERIAL PRIMARY KEY,
       nom varchar
);

insert into poste(nom) values ('gardien'),('defenseur'),('milieu'),('attaquant');

CREATE TABLE club(
        id  SERIAL PRIMARY KEY,
        code_club varchar unique ,
        intitule varchar
);

create table nationalite(
        id serial PRIMARY KEY ,
        code varchar unique ,
        intitule varchar
);

CREATE TABLE caracteristiquejoueur(
        id  SERIAL PRIMARY KEY,
        idjoueur int references joueur(id),
        idnationaliter int references nationalite(id),
        idclub int references club(id),
        dates Date
);

CREATE TABLE joueurposte(
        id  SERIAL PRIMARY KEY,
        idjoueur int references joueur(id),
        idposte int references poste(id),
        dates Date
);

CREATE TABLE caracteristique(
        id  SERIAL PRIMARY KEY,
        nom varchar,
        abreviation varchar unique
);

INSERT INTO caracteristique (nom, abreviation)
VALUES ('physique', 'PHY'), ('tir', 'TIR'), ('vitesse', 'VIT'), ('passe', 'PAS'), ('défense', 'DEF'), ('dribble', 'DRI');



create table statistiquejoueur(
         id serial PRIMARY KEY ,
         idjoueur int references joueur(id),
         idcaracteristique int references caracteristique(id),
         note double precision
);

CREATE TABLE formation(
        id  SERIAL PRIMARY KEY,
        nom varchar
);


CREATE TABLE caracteristiqueformation(
        id  SERIAL PRIMARY KEY,
        idformation int references formation(id),
        idposte int references poste(id),
        nbr int
);

CREATE TABLE equipe(
         id  SERIAL PRIMARY KEY,
         idclub int references club(id),
         idcaracteristiqueformation int references caracteristiqueformation(id),
         idcaracteristiquejoueur int references caracteristiquejoueur(id)
);

CREATE TABLE coefficient(
        id  SERIAL PRIMARY KEY,
        poste int references poste(id),
        caracteristique int references caracteristique(id),
        coef int
);


