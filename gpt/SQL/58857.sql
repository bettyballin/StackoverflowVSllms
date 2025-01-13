SELECT u1.name as UserName\n   FROM Message m1\n   JOIN User u1 ON u1.uid = m1.UserFromId\n   GROUP BY u1.name\n   HAVING COUNT(m1.UserFromId) > 3;