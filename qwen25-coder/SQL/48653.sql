CREATE TEMP TABLE tempTable (id int serial, folio int);\n\n-- Insert into an intermediate table or use a named cursor first\nINSERT INTO tempTable(folio)\nSELECT folio FROM regularTable ORDER BY folio;\n\n-- Now you can paginate from tempTable using the id