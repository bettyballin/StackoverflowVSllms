SELECT object_name(constid) as constraint_name \nFROM sysreferences \nWHERE tableid = object_id('city')