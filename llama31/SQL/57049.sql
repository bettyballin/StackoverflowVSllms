SELECT \n  GROUP_CONCAT(nq.email ORDER BY nq.date ASC SEPARATOR '|'), \n  nq.newsletterid, \n  nq.date, \n  n.subject, \n  n.body, \n  n.from\nFROM \n  (SELECT \n     email, \n     newsletterid, \n     date, \n     ROW_NUMBER() OVER (PARTITION BY newsletterid ORDER BY date ASC) AS row_num\n   FROM \n     newsletter_queue \n   WHERE \n     status='0') AS nq\nINNER JOIN \n  newsletters n ON nq.newsletterid = n.id\nWHERE \n  nq.row_num <= 125\nGROUP BY \n  nq.newsletterid