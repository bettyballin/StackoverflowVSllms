CREATE OR REPLACE PROCEDURE insert_data(\n    p_ids   IN  OCIVARCHAR2LIST,\n    p_names IN  OCIVARCHAR2LIST\n) IS\nBEGIN\n    FORALL i IN INDICES OF p_ids\n        INSERT INTO your_table (id, name)\n        VALUES (p_ids(i), p_names(i));\nEND;