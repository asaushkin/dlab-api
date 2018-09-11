CREATE TABLE public.quiz (
	id bigint NOT NULL,
	description character varying(255),
	name character varying(64) NOT NULL
);

--------------------------------------------------------------------------------

ALTER TABLE public.quiz
	ADD CONSTRAINT quiz_pkey PRIMARY KEY (id);
