SELECT \n    t1.productId, \n    DateDiff("d", t2.statusDate, t1.statusDate) AS LeadTime\nFROM \n    log t1\nINNER JOIN \n    (SELECT productId, MIN(statusDate) AS statusDate\n     FROM log\n     WHERE status = 01\n     GROUP BY productId) t2 \nON \n    t1.productId = t2.productId\nWHERE \n    t1.status = 03;