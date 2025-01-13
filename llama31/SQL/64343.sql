CREATE TABLE products (\n  id serial NOT NULL,\n  "name" character varying(255) NOT NULL,\n  default_language_id integer NOT NULL,\n  CONSTRAINT products_pkey PRIMARY KEY (id),\n  CONSTRAINT products_default_language_id_fkey FOREIGN KEY (default_language_id)\n      REFERENCES languages (id) MATCH SIMPLE\n      ON UPDATE CASCADE ON DELETE CASCADE\n);