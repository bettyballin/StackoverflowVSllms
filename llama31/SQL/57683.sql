DO $$\nDECLARE\n  i INT;\nBEGIN\n  FOR i IN 1..3 LOOP\n    EXECUTE 'CREATE TABLE table_' || i || ' (id SERIAL PRIMARY KEY, name VARCHAR(50))';\n  END LOOP;\nEND $$;