CREATE TABLE mytable (\n    id SERIAL PRIMARY KEY,\n    datetime_field timestamp,\n    time_specified boolean NOT NULL DEFAULT FALSE\n);