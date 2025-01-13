SELECT pt.id, pt.`date`, t.title, pt.`text`\nFROM Top_Level t INNER JOIN Post pt ON (t.post_id = pt.id)\n LEFT OUTER JOIN (Comment c INNER JOIN Post pc ON (c.post_id = pc.id))\n   ON (c.toplv_id = t.post_id)\nGROUP BY pt.id\nORDER BY MAX(GREATEST(pt.`date`, pc.`date`)) ASC;