--
-- PostgreSQL database dump
--

-- Dumped from database version 17.0 (Debian 17.0-1.pgdg120+1)
-- Dumped by pg_dump version 17.0 (Debian 17.0-1.pgdg120+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
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
-- Name: appliances; Type: TABLE; Schema: public; Owner: silent_rider
--

CREATE TABLE public.appliances (
    id bigint NOT NULL,
    available_online boolean NOT NULL,
    country character varying(255) NOT NULL,
    installment_option boolean NOT NULL,
    manufacturer character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    type character varying(255) NOT NULL,
    CONSTRAINT appliances_type_check CHECK (((type)::text = ANY ((ARRAY['COMPUTER'::character varying, 'FRIDGE'::character varying, 'SMARTPHONE'::character varying, 'TV'::character varying, 'VACUUM'::character varying])::text[])))
);


ALTER TABLE public.appliances OWNER TO silent_rider;

--
-- Name: appliances_id_seq; Type: SEQUENCE; Schema: public; Owner: silent_rider
--

ALTER TABLE public.appliances ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.appliances_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: computers; Type: TABLE; Schema: public; Owner: silent_rider
--

CREATE TABLE public.computers (
    id bigint NOT NULL,
    appliance_name character varying(255) NOT NULL,
    color character varying(255) NOT NULL,
    in_stock boolean NOT NULL,
    name character varying(255) NOT NULL,
    price integer NOT NULL,
    serial_number character varying(255) NOT NULL,
    size character varying(50) NOT NULL,
    type character varying(255) NOT NULL,
    category character varying(255),
    processor_type character varying(255),
    appliance_id bigint NOT NULL
);


ALTER TABLE public.computers OWNER TO silent_rider;

--
-- Name: computers_id_seq; Type: SEQUENCE; Schema: public; Owner: silent_rider
--

ALTER TABLE public.computers ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.computers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: fridges; Type: TABLE; Schema: public; Owner: silent_rider
--

CREATE TABLE public.fridges (
    id bigint NOT NULL,
    appliance_name character varying(255) NOT NULL,
    color character varying(255) NOT NULL,
    in_stock boolean NOT NULL,
    name character varying(255) NOT NULL,
    price integer NOT NULL,
    serial_number character varying(255) NOT NULL,
    size character varying(50) NOT NULL,
    type character varying(255) NOT NULL,
    compressor_type character varying(255),
    doors_count integer,
    appliance_id bigint NOT NULL
);


ALTER TABLE public.fridges OWNER TO silent_rider;

--
-- Name: fridges_id_seq; Type: SEQUENCE; Schema: public; Owner: silent_rider
--

ALTER TABLE public.fridges ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.fridges_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: smartphones; Type: TABLE; Schema: public; Owner: silent_rider
--

CREATE TABLE public.smartphones (
    id bigint NOT NULL,
    appliance_name character varying(255) NOT NULL,
    color character varying(255) NOT NULL,
    in_stock boolean NOT NULL,
    name character varying(255) NOT NULL,
    price integer NOT NULL,
    serial_number character varying(255) NOT NULL,
    size character varying(50) NOT NULL,
    type character varying(255) NOT NULL,
    cameras_count integer,
    memory integer,
    appliance_id bigint NOT NULL
);


ALTER TABLE public.smartphones OWNER TO silent_rider;

--
-- Name: smartphones_id_seq; Type: SEQUENCE; Schema: public; Owner: silent_rider
--

ALTER TABLE public.smartphones ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.smartphones_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: tvs; Type: TABLE; Schema: public; Owner: silent_rider
--

CREATE TABLE public.tvs (
    id bigint NOT NULL,
    appliance_name character varying(255) NOT NULL,
    color character varying(255) NOT NULL,
    in_stock boolean NOT NULL,
    name character varying(255) NOT NULL,
    price integer NOT NULL,
    serial_number character varying(255) NOT NULL,
    size character varying(50) NOT NULL,
    type character varying(255) NOT NULL,
    category character varying(255),
    technology character varying(255),
    appliance_id bigint NOT NULL
);


ALTER TABLE public.tvs OWNER TO silent_rider;

--
-- Name: tvs_id_seq; Type: SEQUENCE; Schema: public; Owner: silent_rider
--

ALTER TABLE public.tvs ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.tvs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: vacuums; Type: TABLE; Schema: public; Owner: silent_rider
--

CREATE TABLE public.vacuums (
    id bigint NOT NULL,
    appliance_name character varying(255) NOT NULL,
    color character varying(255) NOT NULL,
    in_stock boolean NOT NULL,
    name character varying(255) NOT NULL,
    price integer NOT NULL,
    serial_number character varying(255) NOT NULL,
    size character varying(50) NOT NULL,
    type character varying(255) NOT NULL,
    dust_bag_volume double precision,
    modes_count integer,
    appliance_id bigint NOT NULL
);


ALTER TABLE public.vacuums OWNER TO silent_rider;

--
-- Name: vacuums_id_seq; Type: SEQUENCE; Schema: public; Owner: silent_rider
--

ALTER TABLE public.vacuums ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.vacuums_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: appliances; Type: TABLE DATA; Schema: public; Owner: silent_rider
--

COPY public.appliances (id, available_online, country, installment_option, manufacturer, name, type) FROM stdin;
1	t	USA	t	TechCorp	Gaming Series X	COMPUTER
2	f	Germany	f	WorkMaster	Office Series Pro	COMPUTER
3	t	South Korea	t	TechWorld	Laptop Series Ultra	COMPUTER
4	t	Japan	f	CoolTech	FrostFree Line 300	FRIDGE
5	f	South Korea	t	FreezeCo	ChillMax Series 500	FRIDGE
6	t	Germany	t	FridgeTech	EcoCool Line 700	FRIDGE
7	t	China	t	ViewPro	Vision Ultra Line	TV
8	f	Japan	f	ElectroWorld	SmartTV Series Plus	TV
9	t	South Korea	t	SamsungTech	QuantumView Line 8K	TV
10	t	South Korea	t	MobileTech	Galaxy Line Z	SMARTPHONE
11	t	USA	f	Apple	iPhone Line 15	SMARTPHONE
12	t	China	t	OnePlus	OnePlus 10 Series	SMARTPHONE
13	t	Germany	f	VacMaster	CleanBot Line X5	VACUUM
14	f	USA	t	DustPro	DustAway Line 3000	VACUUM
15	t	UK	t	VacuumTech	TurboClean Series V8	VACUUM
\.


--
-- Data for Name: computers; Type: TABLE DATA; Schema: public; Owner: silent_rider
--

COPY public.computers (id, appliance_name, color, in_stock, name, price, serial_number, size, type, category, processor_type, appliance_id) FROM stdin;
1	Gaming Series X	Black	t	GameMaster Pro	1500	GM12345	15.6 inches	COMPUTER	Gaming	Intel i9	1
2	Gaming Series X	Red	t	GamePro Elite	2000	GM54321	17.3 inches	COMPUTER	Gaming	AMD Ryzen 7	1
3	Office Series Pro	Silver	t	Office Series Pro Model 1	800	OSP12345	14 inches	COMPUTER	Business	Intel i5	2
4	Office Series Pro	Gray	t	Office Series Pro Model 2	950	OSP67890	15 inches	COMPUTER	Business	AMD Ryzen 5	2
5	Laptop Series Ultra	Space Gray	t	Laptop Series Ultra Model 1	1400	LSU12345	13 inches	COMPUTER	Ultrabook	Intel i7	3
6	Laptop Series Ultra	Silver	t	Laptop Series Ultra Model 2	1600	LSU67890	14 inches	COMPUTER	Ultrabook	AMD Ryzen 7	3
\.


--
-- Data for Name: fridges; Type: TABLE DATA; Schema: public; Owner: silent_rider
--

COPY public.fridges (id, appliance_name, color, in_stock, name, price, serial_number, size, type, compressor_type, doors_count, appliance_id) FROM stdin;
1	FrostFree Line 300	White	t	FrostFree Line 300 Model 1	900	FFL300123	350 liters	FRIDGE	Inverter	2	4
2	FrostFree Line 300	Silver	t	FrostFree Line 300 Model 2	1050	FFL300456	400 liters	FRIDGE	Standard	3	4
3	ChillMax Series 500	Black	t	ChillMax Series 500 Model 1	1200	CMS500123	500 liters	FRIDGE	Dual	2	5
4	ChillMax Series 500	White	t	ChillMax Series 500 Model 2	1300	CMS500456	550 liters	FRIDGE	Inverter	4	5
5	EcoCool Line 700	Silver	t	EcoCool Line 700 Model 1	700	ECL700123	200 liters	FRIDGE	Energy-efficient	1	6
6	EcoCool Line 700	Black	t	EcoCool Line 700 Model 2	800	ECL700456	300 liters	FRIDGE	Eco-friendly	2	6
\.


--
-- Data for Name: smartphones; Type: TABLE DATA; Schema: public; Owner: silent_rider
--

COPY public.smartphones (id, appliance_name, color, in_stock, name, price, serial_number, size, type, cameras_count, memory, appliance_id) FROM stdin;
1	Galaxy Line Z	Black	t	Galaxy Line Z Model 1	999	GLZ12345	6.1 inches	SMARTPHONE	3	128	10
2	Galaxy Line Z	Blue	t	Galaxy Line Z Model 2	1199	GLZ67890	6.7 inches	SMARTPHONE	4	256	10
3	iPhone Line 15	Space Gray	t	iPhone Line 15 Model 1	799	IPL15123	6.1 inches	SMARTPHONE	2	128	11
4	iPhone Line 15	Silver	t	iPhone Line 15 Model 2	999	IPL15678	6.7 inches	SMARTPHONE	3	256	11
5	OnePlus 10 Series	Morning Mist	t	OnePlus 10 Series Model 1	899	OPS10123	6.55 inches	SMARTPHONE	3	128	12
6	OnePlus 10 Series	Volcanic Black	t	OnePlus 10 Series Model 2	999	OPS10678	6.7 inches	SMARTPHONE	4	256	12
\.


--
-- Data for Name: tvs; Type: TABLE DATA; Schema: public; Owner: silent_rider
--

COPY public.tvs (id, appliance_name, color, in_stock, name, price, serial_number, size, type, category, technology, appliance_id) FROM stdin;
1	Vision Ultra Line	Black	t	Vision Ultra Line Model 1	1000	VUL12345	55 inches	TV	4K	LED	7
2	Vision Ultra Line	Silver	t	Vision Ultra Line Model 2	1300	VUL67890	65 inches	TV	8K	OLED	7
3	SmartTV Series Plus	Black	t	SmartTV Series Plus Model 1	900	STSP12345	50 inches	TV	Smart TV	QLED	8
4	SmartTV Series Plus	Silver	t	SmartTV Series Plus Model 2	1000	STSP67890	55 inches	TV	Smart TV	LED	8
5	QuantumView Line 8K	Black	t	QuantumView Line 8K Model 1	4000	QV8K12345	75 inches	TV	8K	Quantum Dot	9
6	QuantumView Line 8K	Silver	t	QuantumView Line 8K Model 2	4500	QV8K67890	85 inches	TV	8K	OLED	9
\.


--
-- Data for Name: vacuums; Type: TABLE DATA; Schema: public; Owner: silent_rider
--

COPY public.vacuums (id, appliance_name, color, in_stock, name, price, serial_number, size, type, dust_bag_volume, modes_count, appliance_id) FROM stdin;
1	CleanBot Line X5	White	t	CleanBot Line X5 Model 1	199	CBX51234	Compact	VACUUM	2.5	5	13
2	CleanBot Line X5	Black	t	CleanBot Line X5 Model 2	220	CBX57689	Compact	VACUUM	3	6	13
3	DustAway Line 3000	Orange	t	DustAway Line 3000 Model 1	250	DAL3000123	Standard	VACUUM	4	8	14
4	DustAway Line 3000	Blue	t	DustAway Line 3000 Model 2	280	DAL3000678	Standard	VACUUM	4.5	10	14
5	TurboClean Series V8	Red	t	TurboClean Series V8 Model 1	350	TCSV81234	Large	VACUUM	5	12	15
6	TurboClean Series V8	Black	t	TurboClean Series V8 Model 2	400	TCSV86789	Large	VACUUM	6	15	15
\.


--
-- Name: appliances_id_seq; Type: SEQUENCE SET; Schema: public; Owner: silent_rider
--

SELECT pg_catalog.setval('public.appliances_id_seq', 15, true);


--
-- Name: computers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: silent_rider
--

SELECT pg_catalog.setval('public.computers_id_seq', 6, true);


--
-- Name: fridges_id_seq; Type: SEQUENCE SET; Schema: public; Owner: silent_rider
--

SELECT pg_catalog.setval('public.fridges_id_seq', 6, true);


--
-- Name: smartphones_id_seq; Type: SEQUENCE SET; Schema: public; Owner: silent_rider
--

SELECT pg_catalog.setval('public.smartphones_id_seq', 6, true);


--
-- Name: tvs_id_seq; Type: SEQUENCE SET; Schema: public; Owner: silent_rider
--

SELECT pg_catalog.setval('public.tvs_id_seq', 6, true);


--
-- Name: vacuums_id_seq; Type: SEQUENCE SET; Schema: public; Owner: silent_rider
--

SELECT pg_catalog.setval('public.vacuums_id_seq', 6, true);


--
-- Name: appliances appliances_pkey; Type: CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.appliances
    ADD CONSTRAINT appliances_pkey PRIMARY KEY (id);


--
-- Name: computers computers_pkey; Type: CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.computers
    ADD CONSTRAINT computers_pkey PRIMARY KEY (id);


--
-- Name: fridges fridges_pkey; Type: CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.fridges
    ADD CONSTRAINT fridges_pkey PRIMARY KEY (id);


--
-- Name: smartphones smartphones_pkey; Type: CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.smartphones
    ADD CONSTRAINT smartphones_pkey PRIMARY KEY (id);


--
-- Name: tvs tvs_pkey; Type: CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.tvs
    ADD CONSTRAINT tvs_pkey PRIMARY KEY (id);


--
-- Name: vacuums uke9jrj823lql7q7famnet1st25; Type: CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.vacuums
    ADD CONSTRAINT uke9jrj823lql7q7famnet1st25 UNIQUE (serial_number);


--
-- Name: smartphones ukemmofye11y9vssw9swgoxrlth; Type: CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.smartphones
    ADD CONSTRAINT ukemmofye11y9vssw9swgoxrlth UNIQUE (name);


--
-- Name: tvs ukh6trvh3qn2vuvqpc3rysdobtp; Type: CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.tvs
    ADD CONSTRAINT ukh6trvh3qn2vuvqpc3rysdobtp UNIQUE (name);


--
-- Name: fridges uki912xj7jhmybctc69j9lxh4et; Type: CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.fridges
    ADD CONSTRAINT uki912xj7jhmybctc69j9lxh4et UNIQUE (name);


--
-- Name: vacuums ukikvrluui02mffqxtl0egxpjbk; Type: CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.vacuums
    ADD CONSTRAINT ukikvrluui02mffqxtl0egxpjbk UNIQUE (name);


--
-- Name: computers ukmsp7gfcmcb1g68u6wnl91x5ne; Type: CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.computers
    ADD CONSTRAINT ukmsp7gfcmcb1g68u6wnl91x5ne UNIQUE (serial_number);


--
-- Name: computers ukqgnree4gmpx1h4dj7ncfdoae4; Type: CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.computers
    ADD CONSTRAINT ukqgnree4gmpx1h4dj7ncfdoae4 UNIQUE (name);


--
-- Name: tvs ukqoldnpx35nt1ap7vixos5qx2h; Type: CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.tvs
    ADD CONSTRAINT ukqoldnpx35nt1ap7vixos5qx2h UNIQUE (serial_number);


--
-- Name: smartphones ukr9ygk82xvwijkbewtx9mdnfth; Type: CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.smartphones
    ADD CONSTRAINT ukr9ygk82xvwijkbewtx9mdnfth UNIQUE (serial_number);


--
-- Name: fridges uks5k8ccvlxb0oggl4vuxn0lws0; Type: CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.fridges
    ADD CONSTRAINT uks5k8ccvlxb0oggl4vuxn0lws0 UNIQUE (serial_number);


--
-- Name: vacuums vacuums_pkey; Type: CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.vacuums
    ADD CONSTRAINT vacuums_pkey PRIMARY KEY (id);


--
-- Name: tvs fk4wldrv2fql6kwdqkdjdd7oxme; Type: FK CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.tvs
    ADD CONSTRAINT fk4wldrv2fql6kwdqkdjdd7oxme FOREIGN KEY (appliance_id) REFERENCES public.appliances(id);


--
-- Name: fridges fk57nql2g6qh3m8h184ufjptbpm; Type: FK CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.fridges
    ADD CONSTRAINT fk57nql2g6qh3m8h184ufjptbpm FOREIGN KEY (appliance_id) REFERENCES public.appliances(id);


--
-- Name: vacuums fkb46y22v3ene0ykcxsu2cf71jy; Type: FK CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.vacuums
    ADD CONSTRAINT fkb46y22v3ene0ykcxsu2cf71jy FOREIGN KEY (appliance_id) REFERENCES public.appliances(id);


--
-- Name: computers fkdps392eucff0pw6c6vtkj96br; Type: FK CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.computers
    ADD CONSTRAINT fkdps392eucff0pw6c6vtkj96br FOREIGN KEY (appliance_id) REFERENCES public.appliances(id);


--
-- Name: smartphones fkg6kq4m6aktgypcc7gga8yaasb; Type: FK CONSTRAINT; Schema: public; Owner: silent_rider
--

ALTER TABLE ONLY public.smartphones
    ADD CONSTRAINT fkg6kq4m6aktgypcc7gga8yaasb FOREIGN KEY (appliance_id) REFERENCES public.appliances(id);


--
-- PostgreSQL database dump complete
--

