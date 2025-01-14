-- Inserting a GL Import record with a credit to Account A and debit to Account B\n\nINSERT INTO gl_interface (\n    batch_source_name,\n    group_id,\n    application_id,\n    document_type,\n    actual_flag,\n    journal_date,\n    currency_code,\n    reference1,\n    entered_dr,\n    entered_cr,\n    account_class,\n    user_je_source_name,\n    user_je_category_name,\n    accounting_date,\n    segment1, -- Company\n    segment2, -- Cost Center\n    segment3, -- Account\n    segment4, -- Subaccount\n    created_by,\n    creation_date,\n    last_updated_by,\n    last_update_date\n) VALUES (\n    'Your Batch Name', -- The batch source name should be set up in Oracle Apps\n    1000, -- Unique group ID for the transaction\n    101, -- Application ID for General Ledger\n    'GENJRNLS', -- Document type is General Journals\n    'A', -- Actual flag ('A' for actual entry)\n    TO_DATE('2023-10-05','YYYY-MM-DD'), -- Date of the journal entry\n    'USD', -- Currency code\n    'TXN12345', -- Reference number for the transaction\n    0, -- Entered DR amount (debit), 0 if credit\n    1000, -- Entered CR amount (credit)\n    NULL, -- Account class can be NULL for standard accounts\n    'Your Source Name', -- The source name should match a value setup in Oracle Apps\n    'Your Category Name', -- The category name should match a value setup in Oracle Apps\n    TO_DATE('2023-10-05','YYYY-MM-DD'), -- Accounting date, typically the same as journal_date\n    '001', -- Segments depend on your chart of accounts definition\n    '001',\n    '40100', -- Replace with the actual GL account you are using\n    NULL,\n    12345, -- User ID that creates the entry\n    SYSDATE, -- Creation date\n    12345, -- Last user who updated the entry\n    SYSDATE  -- Last update date\n);\n\n-- Inserting the corresponding debit transaction\n\nINSERT INTO gl_interface (\n    batch_source_name,\n    group_id,\n    application_id,\n    document_type,\n    actual_flag,\n    journal_date,\n    currency_code,\n    reference1,\n    entered_dr,\n    entered_cr,\n    account_class,\n    user_je_source_name,\n    user_je_category_name,\n    accounting_date,\n    segment1, -- Company\n    segment2, -- Cost Center\n    segment3, -- Account\n    segment4, -- Subaccount\n    created_by,\n    creation_date,\n    last_updated_by,\n    last_update_date\n) VALUES (\n    'Your Batch Name', -- Same batch source name as above\n    1000, -- Same group ID to link them together\n    101, -- Application ID for General Ledger\n    'GENJRNLS',\n    'A',\n    TO_DATE('2023-10-05','YYYY-MM-DD'), -- Same date as above for the transaction set\n    'USD',\n    'TXN12345', -- Same reference number to indicate it's part of the same transaction\n    1000, -- Debit amount matching the credit in the opposite transaction\n    0, -- No credit amount here\n    NULL,\n    'Your Source Name',\n    'Your Category Name',\n    TO_DATE('2023-10-05','YYYY-MM-DD'),\n    '001', -- Segments depend on your chart of accounts definition\n    '001',\n    '40200', -- Replace with the second GL account you are using\n    NULL,\n    12345, -- User ID that creates the entry\n    SYSDATE, -- Creation date\n    12345, -- Last user who updated the entry\n    SYSDATE  -- Last update date\n);