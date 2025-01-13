CREATE TABLE versions (\n  id SERIAL PRIMARY KEY,\n  thing_id INTEGER NOT NULL,\n  thing_type VARCHAR(50) NOT NULL,\n  version JSONB NOT NULL,\n  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n  previous_version_id INTEGER\n);\n\nCREATE INDEX idx_versions_thing_id ON versions (thing_id);\nCREATE INDEX idx_versions_thing_type ON versions (thing_type);