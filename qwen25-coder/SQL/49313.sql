SELECT\n    t1.id,\n    t1.title,\n    CASE \n        WHEN t2.link_id = 123 THEN t2.link_id \n        ELSE NULL \n    END AS refId\nFROM\n    t1\nLEFT JOIN\n    t2 ON (t1.id = t2.title_id);