CREATE TABLE joueur(
      id  SERIAL PRIMARY KEY,
      nom varchar,
      photo varchar
);


CREATE TABLE poste(
       id  SERIAL PRIMARY KEY,
       nom varchar
);

CREATE TABLE club(
        id  SERIAL PRIMARY KEY,
        nom varchar,
        photo varchar
);

create table nationalite(
        id serial PRIMARY KEY ,
        nom varchar
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
        abreviation varchar
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
        idposte int references poste(id),
        idcaracteristique int references caracteristique(id),
        coeff int
);


