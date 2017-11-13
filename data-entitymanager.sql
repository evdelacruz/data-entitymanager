-- Database  : dataentitymanager
-- Version   : PostgreSQL 9.6.1

SET check_function_bodies = false;
--
-- Structure for table user (OID = 17558) :
--
SET search_path = public, pg_catalog;
CREATE TABLE public."user" (
    id serial NOT NULL,
    username varchar(50) NOT NULL,
    password varchar(100) NOT NULL,
    enabled boolean NOT NULL
)
WITH (oids = false);
--
-- Structure for table profile (OID = 17566) :
--
CREATE TABLE public.profile (
    id integer NOT NULL,
    given_names varchar(100) NOT NULL,
    surnames varchar(100) NOT NULL,
    email varchar(50) NOT NULL,
    age integer NOT NULL
)
WITH (oids = false);
--
-- Definition for index user_pkey (OID = 17562) :
--
ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey
    PRIMARY KEY (id);
--
-- Definition for index profile_pkey (OID = 17569) :
--
ALTER TABLE ONLY profile
    ADD CONSTRAINT profile_pkey
    PRIMARY KEY (id);
--
-- Definition for index profile_id_fk (OID = 17576) :
--
ALTER TABLE ONLY profile
    ADD CONSTRAINT profile_id_fk
    FOREIGN KEY (id) REFERENCES "user"(id) ON DELETE CASCADE;
--
-- Definition for index user_username_key (OID = 17581) :
--
ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_username_key
    UNIQUE (username);
--
-- Comments
--
COMMENT ON SCHEMA public IS 'standard public schema';
