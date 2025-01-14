CREATE FUNCTION GetActiveUsers()\n   RETURNS TABLE\n   AS\n   RETURN (\n       SELECT id, name, email\n       FROM Users\n       WHERE status = 'active'\n   );\n\n   -- Usage\n   SELECT * FROM GetActiveUsers();