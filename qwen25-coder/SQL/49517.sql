CREATE OR REPLACE FUNCTION EXECUTE_UPDATE(\n  ids IN NUMBER_LIST,\n  value IN INTEGER\n) RETURN INTEGER IS\nBEGIN\n  UPDATE table1 \n  SET col1 = col1 - value \n  WHERE id IN (SELECT * FROM TABLE(ids));\n\n  RETURN SQL%ROWCOUNT;\nEND;