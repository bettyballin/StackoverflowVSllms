SELECT count(*) \nFROM transactions \nWHERE CLEAN_ME(desc) = ? \n  AND dated_on = ? \n  AND amount = ?