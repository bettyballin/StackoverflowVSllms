-- Example of creating a composite index on cache_name and cache_event_id\nCREATE INDEX idx_cache_lookup ON YourTableName (cache_name, cache_event_id);