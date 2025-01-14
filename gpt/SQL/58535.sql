CREATE TABLE my_table (\n    id INTEGER PRIMARY KEY,\n    uuid TEXT UNIQUE NOT NULL,\n    column1 TEXT,\n    column2 TEXT,\n    -- other columns\n    last_synced TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n);