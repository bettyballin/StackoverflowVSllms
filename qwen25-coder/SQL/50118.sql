SELECT ID\nFROM your_table_name\nWHERE Value IN (2, 5) -- or (1, 3) etc., depending on what values you are searching for\nGROUP BY ID\nHAVING COUNT(DISTINCT Value) = 2; -- This number should match the number of distinct values you are looking for