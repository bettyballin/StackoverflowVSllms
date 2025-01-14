SELECT \n    i.id,\n    i.title,\n    i.created_at,\n    COUNT(v.id) AS votes,\n    DATEDIFF(NOW(), i.created_at) AS age_in_days,\n    (COUNT(v.id) / (DATEDIFF(NOW(), i.created_at) + 1)) AS score\nFROM \n    illustrations i\nLEFT JOIN \n    votes v ON i.id = v.illustration_id\nGROUP BY \n    i.id\nORDER BY \n    score DESC\nLIMIT 20;