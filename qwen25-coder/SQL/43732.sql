SELECT \n    t1.id, \n    t1.title, \n    t1.contenttext,\n    t1.fk_idothertable,\n    t1.version\nFROM \n    mytable AS t1\nINNER JOIN \n    (SELECT fk_idothertable, MAX(version) AS topversion\n     FROM mytable\n     GROUP BY fk_idothertable) AS subquery\nON \n    t1.fk_idothertable = subquery.fk_idothertable\n    AND t1.version = subquery.topversion;