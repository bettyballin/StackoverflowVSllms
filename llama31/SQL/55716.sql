CREATE UNIQUE INDEX idx_name ON table_name (CASE WHEN deleted_date IS NULL THEN column_name END);