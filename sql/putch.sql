--
-- Data for Name: quiz; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY quiz.quiz (id, description, name) FROM stdin;
1	Quiz by Android to Professionals	Geo Quiz
\.

--
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY quiz.question (id, answer, name, quiz_id) FROM stdin;
2	t	Canberra is the capital of Australia.	1
3	t	The Pacific Ocean is larger than the Atlantic Ocean.	1
4	f	The Suez Canal connects the Red Sea and the Indian Ocean.	1
5	f	The source of the Nile River is in Egypt.	1
6	t	The Amazon River is the longest river in the Americas.	1
7	t	Lake Baikal is the world’s oldest and deepest freshwater lake.	1
\.



--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 7, true);

