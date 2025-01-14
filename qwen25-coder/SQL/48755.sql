SELECT tags.*, COUNT(ct2.company_id) AS count\nFROM company2tag ct1\nJOIN (\n    SELECT company_id \n    FROM company2tag \n    WHERE tag_id = 18\n    GROUP BY company_id\n    HAVING COUNT(company_id) = 1\n) temp ON ct1.company_id = temp.company_id\nJOIN tags ON tags.id = ct1.tag_id\nWHERE tags.id != 18\nGROUP BY ct1.tag_id\nORDER BY count DESC\nLIMIT 5;