SELECT u1.name as UserName from Message m1, User u1 \n  WHERE u1.uid = m1.UserFromID GROUP BY u1.name HAVING count(m1.UserFromId)>3