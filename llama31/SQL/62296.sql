SELECT \n  id, \n  name, \n  points, \n  (SELECT COUNT(*) FROM users WHERE points > u.points) + 1 AS rank\nFROM \n  users u\nWHERE \n  id = 3;