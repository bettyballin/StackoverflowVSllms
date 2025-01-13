SELECT [p].ProductID,\n       [p].Name,\n       MAX(CASE [m].MetaKey\n             WHEN 'A'\n               THEN [m].MetaValue\n           END) AS A,\n       MAX(CASE [m].MetaKey\n             WHEN 'B'\n               THEN [m].MetaValue\n           END) AS B,\n       MAX(CASE [m].MetaKey\n             WHEN 'C'\n               THEN [m].MetaValue\n           END) AS C\nFROM   Products [p]\n       INNER JOIN ProductMeta [m]\n         ON [p].ProductId = [m].ProductId\nGROUP  BY [p].ProductID,\n          [p].Name 