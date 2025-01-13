DECLARE @BatchSize INT = 10000;\n   DECLARE @RowsAffected INT;\n\n   SET @RowsAffected = @BatchSize;\n\n   WHILE (@RowsAffected = @BatchSize)\n   BEGIN\n       BEGIN TRANSACTION;\n\n       UPDATE TOP (@BatchSize) YourTable\n       SET ColumnToUpdate = NewValue\n       WHERE SomeCondition;\n\n       SET @RowsAffected = @@ROWCOUNT;\n\n       COMMIT TRANSACTION;\n   END;