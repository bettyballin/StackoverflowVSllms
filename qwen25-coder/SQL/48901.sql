DECLARE @BatchSize INT = 1000, @Offset INT = 0;\n\n   WHILE 1=1\n   BEGIN\n       UPDATE TOP (@BatchSize) t1\n       SET column = new_value\n       FROM YourTable t1\n       INNER JOIN AnotherTable t2 ON t1.key = t2.key\n       WHERE <your_conditions>\n       OFFSET @Offset ROWS FETCH NEXT @BatchSize ROWS ONLY;\n\n       IF @@ROWCOUNT < @BatchSize BREAK;\n       \n       SET @Offset += @BatchSize;\n   END