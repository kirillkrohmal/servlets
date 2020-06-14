CREATE TABLE cruduser
(
  id serial NOT NULL,
  name character varying(2000),
  login character varying(2000) UNIQUE,
  email character varying(2000),
  createDate timestamp,
  CONSTRAINT cruduser_pkey PRIMARY KEY (id)
);

