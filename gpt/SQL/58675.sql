SELECT *\nFROM TABLE\nWHERE REGEXP_REPLACE(Phonenumber, '[^0-9]', '') = '555123456';