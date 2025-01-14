WITH RECURSIVE PROCEDURE_DEPS (NAME, TYPE, REFERENCED_NAME, REFERENCED_TYPE, LEVEL) AS (\n  SELECT NAME,\n         TYPE,\n         REFERENCED_NAME,\n         REFERENCED_TYPE,\n         1 AS LEVEL\n  FROM USER_DEPENDENCIES\n  WHERE REFERENCING_NAME = 'YOUR_PROCEDURE_NAME' -- Replace with your procedure name\n    AND REFERENCED_TYPE = 'PROCEDURE'\n  \n  UNION ALL\n  \n  SELECT d.NAME,\n         d.TYPE,\n         d.REFERENCED_NAME,\n         d.REFERENCED_TYPE,\n         deps.LEVEL + 1 AS LEVEL\n  FROM USER_DEPENDENCIES d\n  JOIN PROCEDURE_DEPS deps ON deps.REFERENCED_NAME = d.NAME\n    AND deps.REFERENCED_TYPE = 'PROCEDURE'\n)\nSELECT REFERENCED_NAME, REFERENCED_TYPE, LEVEL\nFROM PROCEDURE_DEPS\nWHERE REFERENCED_TYPE = 'PROCEDURE'\nORDER BY LEVEL, REFERENCED_NAME;