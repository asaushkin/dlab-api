CREATE TABLE public.question (
	id bigint NOT NULL,
	answer boolean NOT NULL,
	name character varying(255) NOT NULL,
	quiz_id bigint NOT NULL
);

--------------------------------------------------------------------------------

ALTER TABLE public.question
	ADD CONSTRAINT fkb0yh0c1qaxfwlcnwo9dms2txf FOREIGN KEY (quiz_id) REFERENCES public.quiz(id);

--------------------------------------------------------------------------------

ALTER TABLE public.question
	ADD CONSTRAINT question_pkey PRIMARY KEY (id);
