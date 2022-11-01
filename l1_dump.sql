--
-- PostgreSQL database dump
--

-- Dumped from database version 14.5
-- Dumped by pg_dump version 14.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: sponzori; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sponzori (
    "IdSponzor" integer NOT NULL,
    "Naziv" text NOT NULL,
    "Iznos" integer NOT NULL
);


ALTER TABLE public.sponzori OWNER TO postgres;

--
-- Name: turnir_sponzor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.turnir_sponzor (
    "IdTurnir" integer NOT NULL,
    "IdSponzor" integer NOT NULL
);


ALTER TABLE public.turnir_sponzor OWNER TO postgres;

--
-- Name: turniri; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.turniri (
    "Naziv" text NOT NULL,
    "Serija" text NOT NULL,
    "Organizator" text[] NOT NULL,
    "Tip" text NOT NULL,
    "Lokacija" text NOT NULL,
    "Format" text NOT NULL,
    "NagradniFond" integer NOT NULL,
    "BrojTimova" integer NOT NULL,
    "DatumPocetka" date NOT NULL,
    "DatumZavrsetka" date NOT NULL,
    "IdTurnir" integer NOT NULL,
    "VerzijaIgre" text NOT NULL,
    "BrojGledatelja" integer NOT NULL
);


ALTER TABLE public.turniri OWNER TO postgres;

--
-- Data for Name: sponzori; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sponzori ("IdSponzor", "Naziv", "Iznos") FROM stdin;
1	Red Organization	200000
2	Blue Corporation	100000
3	V2	75000
4	Gen Empower	150000
5	Zed Corporation	50000
\.


--
-- Data for Name: turnir_sponzor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.turnir_sponzor ("IdTurnir", "IdSponzor") FROM stdin;
1	2
1	3
2	3
2	4
3	3
3	4
4	3
4	4
6	3
6	4
7	5
8	3
9	2
9	4
10	1
10	3
12	3
12	5
5	3
5	4
5	5
11	5
\.


--
-- Data for Name: turniri; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.turniri ("Naziv", "Serija", "Organizator", "Tip", "Lokacija", "Format", "NagradniFond", "BrojTimova", "DatumPocetka", "DatumZavrsetka", "IdTurnir", "VerzijaIgre", "BrojGledatelja") FROM stdin;
The World Championship 2022	The World Championship	{"Blue Corporation",V2}	Offline	Singapore	Round-robin	17000000	20	2022-10-15	2022-10-30	1	7.31c	1000000
First Quaterly	Point System	{V2,"Gen Empower"}	Offline	London	Round-robin	225000	8	2018-02-04	2018-02-06	2	7.31c	80000
Second Quaterly	Point System	{V2,"Gen Empower"}	Offline	Seattle	Round-robin	225000	10	2018-04-06	2018-04-12	3	7.31c	65000
Third Quaterly	Point System	{V2,"Gen Empower"}	Offline	Tokyo	Round-robin	225000	12	2018-06-08	2018-06-15	4	7.31c	70000
Fourth Quaterly	Point System	{V2,"Gen Empower","Zed Corporation"}	Offline	Vancouver	Round-robin	275000	16	2018-07-04	2018-07-12	5	7.31c	88000
Autumn Battle	Point System	{V2,"Gen Empower"}	Online	Internet	Double elimination	225000	12	2019-04-17	2019-04-21	6	7.22a	63000
Majorly Barcelona 2020	Barcelona Series	{"Zed Corporation"}	Online	Internet	Single elimination	50000	10	2020-10-08	2020-10-12	7	7.15b	45000
Stockholm Minor	Minor	{V2}	Online	Internet	Round-robin	75000	8	2017-12-02	2017-12-10	8	6.89d	760000
Beijing Major	Major	{"Blue Corporation","Gen Empower"}	Offline	Beijing	Double-elimination	250000	16	2016-04-25	2016-05-04	9	6.62c	120000
Zagreb Minor	Minor	{"Red Corporation",V2}	Offline	Beijing	Double-elimination	275000	8	2022-03-12	0202-03-16	10	7.32dc	580000
Kansas Major	Major	{"AI Inc."}	Offline	Kansas	Single elimination	65000	12	2021-03-11	2021-03-15	11	7.32dc	55000
Paris Justice	Point System	{"Zed Corporation",V2}	Online	Paris	Double-elimination	125000	12	2022-08-02	2022-08-08	12	7.33d	113000
\.


--
-- Name: sponzori IdSponzor; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sponzori
    ADD CONSTRAINT "IdSponzor" UNIQUE ("IdSponzor");


--
-- Name: turniri IdTurnir; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turniri
    ADD CONSTRAINT "IdTurnir" UNIQUE ("IdTurnir");


--
-- Name: sponzori sponzori_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sponzori
    ADD CONSTRAINT sponzori_pkey PRIMARY KEY ("IdSponzor");


--
-- Name: turnir_sponzor turnir_sponzor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turnir_sponzor
    ADD CONSTRAINT turnir_sponzor_pkey PRIMARY KEY ("IdTurnir", "IdSponzor");


--
-- Name: turniri turniri_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turniri
    ADD CONSTRAINT turniri_pkey PRIMARY KEY ("Naziv");


--
-- Name: turnir_sponzor sponzor_veza; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turnir_sponzor
    ADD CONSTRAINT sponzor_veza FOREIGN KEY ("IdSponzor") REFERENCES public.sponzori("IdSponzor") NOT VALID;


--
-- Name: turnir_sponzor turnir_veza; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turnir_sponzor
    ADD CONSTRAINT turnir_veza FOREIGN KEY ("IdTurnir") REFERENCES public.turniri("IdTurnir") NOT VALID;


--
-- PostgreSQL database dump complete
--

