CREATE INDEX trgm_idx ON names USING gin (name gin_trgm_ops);