SELECT DISTINCT p.*\nFROM Property p\nJOIN Property_Feature pf1 ON p.pid = pf1.pid AND pf1.fid = (SELECT fid FROM Feature WHERE name = 'air conditioning')\nJOIN Property_Feature pf2 ON p.pid = pf2.pid AND pf2.fid = (SELECT fid FROM Feature WHERE name = 'pool')\nJOIN Property_Feature pf3 ON p.pid = pf3.pid AND pf3.fid = (SELECT fid FROM Feature WHERE name = 'laundry on-site');