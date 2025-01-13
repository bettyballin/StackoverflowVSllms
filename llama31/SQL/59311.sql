BEGIN TRANSACTION;\n\n-- Acquire a row-level lock on the row being updated\nSELECT * FROM mytable WHERE id = $1 FOR UPDATE;\n\n-- Update the row and check if the boolean column has changed\nUPDATE mytable SET myboolean = $2 WHERE id = $1;\n\n-- Check if the row was updated and perform the action if necessary\nIF (ROW_COUNT = 1 AND $2 = TRUE) THEN\n    -- Perform the action here\nEND IF;\n\nCOMMIT;