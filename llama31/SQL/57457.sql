CREATE TABLE detectors (\n    id SERIAL PRIMARY KEY,\n    name VARCHAR(50) NOT NULL,\n    description TEXT\n);\n\nCREATE TABLE parameters (\n    id SERIAL PRIMARY KEY,\n    detector_id INTEGER NOT NULL REFERENCES detectors(id),\n    name VARCHAR(50) NOT NULL,\n    value VARCHAR(100) NOT NULL,\n    is_static BOOLEAN NOT NULL DEFAULT TRUE\n);\n\nCREATE TABLE runs (\n    id SERIAL PRIMARY KEY,\n    start_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n    end_time TIMESTAMP,\n    run_number INTEGER NOT NULL\n);\n\nCREATE TABLE parameter_changes (\n    id SERIAL PRIMARY KEY,\n    run_id INTEGER NOT NULL REFERENCES runs(id),\n    parameter_id INTEGER NOT NULL REFERENCES parameters(id),\n    old_value VARCHAR(100) NOT NULL,\n    new_value VARCHAR(100) NOT NULL,\n    changed_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP\n);