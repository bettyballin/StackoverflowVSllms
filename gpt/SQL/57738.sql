BEGIN TRANSACTION;\n\n-- Execute the DELETE statement\nDELETE FROM your_table WHERE your_conditions;\n\n-- Preview the changes\nSELECT * FROM your_table WHERE your_conditions;\n\n-- Rollback the transaction to undo changes\nROLLBACK;