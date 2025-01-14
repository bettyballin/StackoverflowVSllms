-- Adding a virtual computed column for sorted titles\nALTER TABLE games ADD COLUMN sorted_title VARCHAR(255) AS (\n    REGEXP_REPLACE(\n        title, \n        '[0-9]+', \n        LPAD(REGEXP_REPLACE(title, '[^0-9]', ''), 10, '0')\n    )\n) PERSISTENT;