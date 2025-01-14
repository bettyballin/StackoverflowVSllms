CREATE TABLE changelog (\n    id INTEGER PRIMARY KEY,\n    uuid TEXT NOT NULL,\n    change_type TEXT CHECK( change_type IN ('insert', 'delete') ),\n    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n);