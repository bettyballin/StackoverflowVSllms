SELECT\n    SUM(CASE WHEN post_count >= 1 AND post_count < 10 THEN 1 ELSE 0 END) AS rank_1,\n    SUM(CASE WHEN post_count >= 10 AND post_count < 25 THEN 1 ELSE 0 END) AS rank_2,\n    SUM(CASE WHEN post_count >= 25 AND post_count < 76 THEN 1 ELSE 0 END) AS rank_3,\n    SUM(CASE WHEN post_count >= 76 AND post_count < 251 THEN 1 ELSE 0 END) AS rank_4,\n    SUM(CASE WHEN post_count >= 251 AND post_count <= 2000 THEN 1 ELSE 0 END) AS rank_5\nFROM _users;