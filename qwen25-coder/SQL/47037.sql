SELECT \n    CASE \n        WHEN name IS NULL THEN 'Name is NULL'\n        WHEN name = '' THEN 'Name is an empty string'\n        ELSE 'Name has some value: ' || NAME\n    END AS name_status\nFROM TABLE_A WHERE id=100;