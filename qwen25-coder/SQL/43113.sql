SELECT PERSON, LANGUAGE, ...\nFROM (\n    SELECT PERSON, LANGUAGE, ...,\n           ROW_NUMBER() OVER (PARTITION BY LANGUAGE ORDER BY PERSON) AS rn\n    FROM A\n)\nWHERE rn = 1;