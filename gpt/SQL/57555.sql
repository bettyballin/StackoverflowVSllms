SELECT COUNT(*) \nFROM transactions \nWHERE REPLACE(REPLACE(REPLACE(desc, '.', ''), '-', ''), ' ', '') = ? \nAND dated_on = ? \nAND amount = ?;