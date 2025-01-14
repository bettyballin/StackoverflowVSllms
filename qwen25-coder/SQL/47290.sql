BEGIN TRANSACTION;\n\n-- Replace 'DELETE' with 'SELECT * FROM' to preview rows affected by delete\nSELECT * FROM [YourTable] WHERE [SomeCondition];\n\n-- If you intended to DELETE, this is how to do it safely:\n-- DELETE FROM [YourTable] WHERE [SomeCondition];\n\n-- If everything looks good, uncomment and run the following line. Otherwise, skip.\n-- COMMIT TRANSACTION;\n\nROLLBACK TRANSACTION;