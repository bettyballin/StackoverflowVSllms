DO\n$$\nDECLARE\n    r RECORD;\nBEGIN\n    FOR r IN\n        SELECT \n            tc.table_schema,\n            tc.table_name,\n            kcu.column_name\n        FROM \n            information_schema.table_constraints AS tc\n            JOIN information_schema.key_column_usage AS kcu\n              ON tc.constraint_name = kcu.constraint_name\n            JOIN information_schema.constraint_column_usage AS ccu\n              ON ccu.constraint_name = tc.constraint_name\n        WHERE constraint_type = 'FOREIGN KEY' AND ccu.table_name = 'address' AND ccu.column_name = 'id'\n    LOOP\n        EXECUTE format('SELECT * FROM %I.%I WHERE %I = 1', r.table_schema, r.table_name, r.column_name);\n    END LOOP;\nEND\n$$;