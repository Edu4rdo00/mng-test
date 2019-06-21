CREATE TABLE IF NOT EXISTS usuario
(
   id integer not null,
   login varchar(255) not null unique,
   senha varchar(255) not null,
   nome varchar(255) not null,
   administrador boolean not null,
   primary key(id)
);
CREATE SEQUENCE IF NOT EXISTS SEQ_USUARIO;

CREATE TABLE IF NOT EXISTS pais
(
   id integer not null,
   nome varchar(255) not null,
   sigla varchar(8) not null,
   gentilico varchar(255) not null,
   primary key(id)
);
CREATE SEQUENCE IF NOT EXISTS SEQ_PAIS;

CREATE TABLE IF NOT EXISTS token
(
   id integer not null,
   token varchar(255) not null,
   id_usuario integer not null,
   exipiracao varchar(255) not null,
   primary key(id),
   foreign key (id_usuario) references usuario
);
CREATE SEQUENCE IF NOT EXISTS SEQ_TOKEN;