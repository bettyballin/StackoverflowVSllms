BEGIN TRANSACTION;\n\n-- Update rows and capture the PKs of the updated rows\nUPDATE Table1 \nSET AlertDate = GETUTCDATE() \nOUTPUT INSERTED.Id -- Capture the primary keys of the updated rows\nWHERE AlertDate IS NULL;\n\nCOMMIT TRANSACTION;