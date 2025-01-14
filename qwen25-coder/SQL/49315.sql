CREATE TEMPORARY TABLE TempUserMessages AS\n   SELECT u1.name as UserName, COUNT(m1.UserFromId) as SentCount \n   FROM Message m1\n   JOIN User u1 ON u1.uid = m1.UserFromId \n   GROUP BY u1.name \n   HAVING SentCount > 3;\n\n   -- Use the temporary table in your queries\n   SELECT UserName FROM TempUserMessages;