select unique_key \nfrom src_table \nwhere natural_key1 = TO_CHAR(:1) \n  and natural_key2 = :2 \n  and natural_key3 = :3;