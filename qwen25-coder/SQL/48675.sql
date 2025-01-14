CREATE PROCEDURE MyProcedure\n    @SomeParameter INT,\n    @AffectedRows INT OUTPUT\nAS\nBEGIN\n    -- Your SQL operations here, e.g., UPDATE\n    UPDATE MyTable SET ColumnName = 'NewValue' WHERE ID = @SomeParameter;\n\n    -- Set the output parameter to @@ROWCOUNT which holds the number of rows affected by the last statement.\n    SET @AffectedRows = @@ROWCOUNT;\nEND