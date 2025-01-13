SELECT \n    i.*,\n    (\n        -- Weight votes more than comments\n        (COUNT(v.id) * 2) + \n        COUNT(c.id) + \n        -- Penalize older illustrations, adjust the date interval based on your site's activity\n        (UNIX_TIMESTAMP(NOW()) - UNIX_TIMESTAMP(i.date_created)) / (24*60*60*30) -- 30 days interval\n    ) AS score\nFROM \n    illustrations i\nLEFT JOIN \n    votes v ON i.id = v.illustration_id\nLEFT JOIN \n    comments c ON i.id = c.illustration_id\nGROUP BY \n    i.id\nORDER BY \n    score DESC\nLIMIT 20;