update work\nset kilometers = calc_kilo,\n    kilo_test = test_kilo\nwhere lc = rm.lc\nAND ld = rm.ld\nAND NVL(le, 'NULL') = NVL(rm.le, 'NULL')\nAND NVL(lf, 'NULL') = NVL(rm.lf, 'NULL')\nAND code = rm.code\nAND lcode = rm.lcode\nand user_id = username;