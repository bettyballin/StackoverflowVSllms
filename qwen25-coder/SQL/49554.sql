CREATE TABLE articles (\n      id SERIAL PRIMARY KEY,\n      body TEXT NOT NULL\n  );\n\n  -- Setting up a GIN index for full text search\n  CREATE INDEX gin_idx ON articles USING GIN(to_tsvector('english', body));