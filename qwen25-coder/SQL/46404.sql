SELECT at.tag, a.date_time\nFROM articles a\nJOIN articletags at ON a.id = at.id\nWHERE a.date_time = (\n    SELECT MAX(a2.date_time)\n    FROM articles a2\n    JOIN articletags at2 ON a2.id = at2.id\n    WHERE at2.tag = at.tag\n)\nGROUP BY at.tag, a.date_time;