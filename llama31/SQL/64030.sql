-- Create a base table with the common fields\nCREATE TABLE media (\n    id SERIAL PRIMARY KEY,\n    name VARCHAR(100),\n    description TEXT,\n    url VARCHAR(255)\n);\n\n-- Create specialized tables that inherit from the base table\nCREATE TABLE tv_series (\n    id INTEGER PRIMARY KEY REFERENCES media(id),\n    season INTEGER,\n    episode INTEGER,\n    airing DATE\n);\n\nCREATE TABLE movies (\n    id INTEGER PRIMARY KEY REFERENCES media(id),\n    release_date DATE,\n    budget INTEGER\n);