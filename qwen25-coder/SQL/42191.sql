CREATE UNIQUE INDEX idx_unique_non_deleted_name ON your_table (name) WHERE deleted = 0;