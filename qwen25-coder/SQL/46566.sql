DROP FUNCTION IF EXISTS PersonName;\n\nDELIMITER |\n\nCREATE FUNCTION PersonName(personID SMALLINT)\nRETURNS CHAR(20)\nBEGIN\n  DECLARE pname CHAR(20) DEFAULT '';\n  SELECT name INTO pname FROM family WHERE ID = personID;\n  RETURN pname;\nEND|\n\nDELIMITER ;