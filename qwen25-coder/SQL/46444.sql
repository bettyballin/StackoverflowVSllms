CREATE TABLE items (\n       id SERIAL PRIMARY KEY,\n       name VARCHAR(100),\n       flags TEXT[]\n   );\n\n   -- Or using JSONB\n   CREATE TABLE items (\n       id SERIAL PRIMARY KEY,\n       name VARCHAR(100),\n       flags JSONB\n   );