--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.10
-- Dumped by pg_dump version 9.4.10
-- Started on 2016-12-16 15:44:53

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2045 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 175 (class 1259 OID 16422)
-- Name: company; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE company (
    company_id bigint NOT NULL,
    company_name text NOT NULL
);


ALTER TABLE company OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 16420)
-- Name: company_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE company_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE company_id_seq OWNER TO postgres;

--
-- TOC entry 2046 (class 0 OID 0)
-- Dependencies: 174
-- Name: company_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE company_id_seq OWNED BY company.company_id;


--
-- TOC entry 177 (class 1259 OID 16433)
-- Name: internship; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE internship (
    internship_id bigint NOT NULL,
    type text NOT NULL,
    company_fk bigint
);


ALTER TABLE internship OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 16431)
-- Name: internship_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE internship_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE internship_id_seq OWNER TO postgres;

--
-- TOC entry 2047 (class 0 OID 0)
-- Dependencies: 176
-- Name: internship_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE internship_id_seq OWNED BY internship.internship_id;


--
-- TOC entry 181 (class 1259 OID 16581)
-- Name: internship_project; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE internship_project (
    internship_id bigint NOT NULL,
    project_id bigint NOT NULL
);


ALTER TABLE internship_project OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16412)
-- Name: person; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE person (
    person_id bigint NOT NULL,
    username text
);


ALTER TABLE person OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 16566)
-- Name: person_internship; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE person_internship (
    person_id bigint NOT NULL,
    internship_id bigint NOT NULL
);


ALTER TABLE person_internship OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 16444)
-- Name: project; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE project (
    project_id integer NOT NULL,
    project_name text NOT NULL
);


ALTER TABLE project OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 16442)
-- Name: projects_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE projects_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE projects_id_seq OWNER TO postgres;

--
-- TOC entry 2048 (class 0 OID 0)
-- Dependencies: 178
-- Name: projects_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE projects_id_seq OWNED BY project.project_id;


--
-- TOC entry 1909 (class 2604 OID 16480)
-- Name: company_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY company ALTER COLUMN company_id SET DEFAULT nextval('company_id_seq'::regclass);


--
-- TOC entry 1910 (class 2604 OID 16495)
-- Name: internship_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY internship ALTER COLUMN internship_id SET DEFAULT nextval('internship_id_seq'::regclass);


--
-- TOC entry 1911 (class 2604 OID 16447)
-- Name: project_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY project ALTER COLUMN project_id SET DEFAULT nextval('projects_id_seq'::regclass);


--
-- TOC entry 1915 (class 2606 OID 16482)
-- Name: company_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY company
    ADD CONSTRAINT company_pkey PRIMARY KEY (company_id);


--
-- TOC entry 1917 (class 2606 OID 16497)
-- Name: internship_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY internship
    ADD CONSTRAINT internship_pkey PRIMARY KEY (internship_id);


--
-- TOC entry 1923 (class 2606 OID 16585)
-- Name: internship_project_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY internship_project
    ADD CONSTRAINT internship_project_pkey PRIMARY KEY (internship_id, project_id);


--
-- TOC entry 1913 (class 2606 OID 16419)
-- Name: l_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY person
    ADD CONSTRAINT l_user_pkey PRIMARY KEY (person_id);


--
-- TOC entry 1921 (class 2606 OID 16570)
-- Name: person_internship_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY person_internship
    ADD CONSTRAINT person_internship_pkey PRIMARY KEY (person_id, internship_id);


--
-- TOC entry 1919 (class 2606 OID 16452)
-- Name: projects_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY project
    ADD CONSTRAINT projects_pkey PRIMARY KEY (project_id);


--
-- TOC entry 1924 (class 2606 OID 16516)
-- Name: company___fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY internship
    ADD CONSTRAINT company___fk FOREIGN KEY (internship_id) REFERENCES company(company_id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1926 (class 2606 OID 16576)
-- Name: internship_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY person_internship
    ADD CONSTRAINT internship_fk FOREIGN KEY (internship_id) REFERENCES internship(internship_id);


--
-- TOC entry 1927 (class 2606 OID 16586)
-- Name: internship_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY internship_project
    ADD CONSTRAINT internship_fk FOREIGN KEY (internship_id) REFERENCES internship(internship_id);


--
-- TOC entry 1925 (class 2606 OID 16571)
-- Name: person_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY person_internship
    ADD CONSTRAINT person_fk FOREIGN KEY (person_id) REFERENCES person(person_id);


--
-- TOC entry 1928 (class 2606 OID 16591)
-- Name: project_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY internship_project
    ADD CONSTRAINT project_fk FOREIGN KEY (project_id) REFERENCES project(project_id);


--
-- TOC entry 2044 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-12-16 15:44:53

--
-- PostgreSQL database dump complete
--

