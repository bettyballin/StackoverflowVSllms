SELECT t1.FooId, t1.Data, t1.CreatedTime\nFROM YourTable t1\nINNER JOIN (\n  SELECT FooId, MAX(CreatedTime) AS MaxCreatedTime\n  FROM YourTable\n  WHERE CONVERT(DATE, CreatedTime) = '2000-01-01'\n  GROUP BY FooId\n) t2 ON t1.FooId = t2.FooId AND t1.CreatedTime = t2.MaxCreatedTime