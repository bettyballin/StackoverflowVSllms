UPDATE YourTableName\nSET Fieldname = REPLACE(REPLACE(Fieldname, CHAR(13), ''), CHAR(10), ' ');