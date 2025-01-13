SELECT \n    a.id, \n    a.title, \n    a.date, \n    grade\nFROM \n    (SELECT \n         p.id, \n         p.title, \n         p.date, \n         p.visible,\n         (SELECT MAX(grade)\n          FROM tests\n          WHERE userid = 41\n          AND presid = p.id) AS grade\n     FROM presentations p) a\nWHERE \n    a.visible = 1\n    AND a.grade >= 5\nORDER BY \n    a.grade DESC;