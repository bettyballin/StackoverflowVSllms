DECLARE\n  l_batch_name  VARCHAR2(100) := 'My Batch';\n  l_batch_description  VARCHAR2(200) := 'My batch description';\n  l_batch_date  DATE := SYSTIMESTAMP;\n  l_batch_control_total  NUMBER := 100;  -- total of all transactions in the batch\n  l_batch_batch_id  NUMBER;\n  l_journal_batch_id  NUMBER;\n\n  l_transaction  gl_interface%ROWTYPE;\nBEGIN\n  -- Create a new batch\n  gl_interface_api.create_batch(\n    p_batch_name => l_batch_name,\n    p_batch_description => l_batch_description,\n    p_batch_date => l_batch_date,\n    p_batch_control_total => l_batch_control_total,\n    p_batch_batch_id => l_batch_batch_id\n  );\n\n  -- Create a new journal entry\n  l_transaction.batch_id := l_batch_batch_id;\n  l_transaction.journal_date := l_batch_date;\n  l_transaction.currency_code := 'USD';\n  l_transaction.accounting_date := l_batch_date;\n  l_transaction.document_date := l_batch_date;\n  l_transaction.document_sequence_id := NULL;\n  l_transaction.batch_name := l_batch_name;\n  l_transaction.description := 'My journal entry';\n  l_transaction.batch_description := l_batch_description;\n  l_transaction.batch_control_total := l_batch_control_total;\n\n  -- Add a transaction line\n  l_transaction.source_batch_id := l_batch_batch_id;\n  l_transaction.source_batch_name := l_batch_name;\n  l_transaction.transaction_type := 'Journal';\n  l_transaction.account_code := ' Assets';\n  l_transaction.accounted_amount := 100;  -- Debit\n  l_transaction.accounted_credit := 0;\n  l_transaction.accounted_debit := 100;\n\n  gl_interface_api.create_transaction(\n    p_batch_id => l_batch_batch_id,\n    p_transaction => l_transaction\n  );\n\n  -- Add another transaction line (credit)\n  l_transaction.account_code := ' Liabilities';\n  l_transaction.accounted_amount := 0;\n  l_transaction.accounted_credit := 100;\n  l_transaction.accounted_debit := 0;\n\n  gl_interface_api.create_transaction(\n    p_batch_id => l_batch_batch_id,\n    p_transaction => l_transaction\n  );\n\n  -- Post the batch\n  gl_interface_api.post_batch(\n    p_batch_id => l_batch_batch_id,\n    p_batch_batch_id => l_batch_batch_id\n  );\n\n  COMMIT;\nEND;