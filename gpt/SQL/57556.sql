SELECT COUNT(*) \nFROM transactions \nWHERE REGEXP_REPLACE(desc, '[^a-zA-Z0-9 ]', '') = ? \nAND dated_on = ? \nAND amount = ?;