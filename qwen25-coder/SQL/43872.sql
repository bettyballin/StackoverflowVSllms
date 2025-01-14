-- Instead of doing the action directly in a stored procedure for ExecuteNonQuery,\n   -- Use ExecuteScalar to get the number of affected rows by adding an output parameter or a select statement.\n   DECLARE @RowCount INT;\n   BEGIN TRANSACTION;\n   UPDATE YourTable SET Column = Value WHERE Condition; \n   SET @RowCount = @@ROWCOUNT;\n   COMMIT TRANSACTION;\n   SELECT @RowCount AS AffectedRows;