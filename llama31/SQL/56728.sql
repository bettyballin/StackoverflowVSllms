SELECT mix_type || ' (' || mix_num || ')' AS description\nFROM acid_batch\nWHERE mix_num < 10;