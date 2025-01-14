CREATE TABLE detectors (\n    detector_id SERIAL PRIMARY KEY,\n    static_param1 text,\n    static_param2 integer,\n    -- other static parameters...\n);\n\nCREATE TABLE runs (\n    run_id SERIAL PRIMARY KEY,\n    detector_id INT NOT NULL REFERENCES detectors(detector_id),\n    run_start_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n    dynamic_params JSONB,  -- Store dynamic parameters as JSON\n    version INTEGER DEFAULT 1,\n    UNIQUE(detector_id, run_start_time)\n);