ALTER TABLE mytable ADD COLUMN mycolumn character varying(50) NOT NULL DEFAULT 'foo';\n\n... some work (set real values as you want)...\n\nALTER TABLE mytable ALTER COLUMN mycolumn DROP DEFAULT;