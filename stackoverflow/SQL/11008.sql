DECLARE @CounterInitialValue INT\nDECLARE @NewCounterValue INT\nSELECT @CounterInitialValue = SELECT counter FROM MyTable WHERE MyID = 1234\n\n-- do stuff with the counter value\n\nUPDATE MyTable\n   SET counter = counter + 1\nWHERE\n   MyID = 1234\n   AND \n   counter = @CounterInitialValue -- prevents the update if counter changed.\n\n-- the value of counter must not change in this scenario.\n-- so we rollback if the update affected no rows\nIF( @@ROWCOUNT = 0 )\n    ROLLBACK