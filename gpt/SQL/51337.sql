CREATE TABLE your_table (\n         id SERIAL PRIMARY KEY,\n         data TEXT,\n         created_at TIMESTAMP\n     ) PARTITION BY RANGE (created_at);