UPDATE table_name\nSET column1 = 'new_value', last_modified = GETDATE()\nWHERE condition;\n\nIF @@ROWCOUNT = 0\nBEGIN\n    -- No rows were updated\nEND\nELSE\nBEGIN\n    -- Rows were updated\nEND