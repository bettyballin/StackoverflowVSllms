-- Example of a scheduled job to delete old articles\nDO $$\nBEGIN\n    DELETE FROM articles WHERE date < CURRENT_DATE - INTERVAL '30 days';\nEND $$;