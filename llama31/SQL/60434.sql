SELECT 'DROP INDEX ' || name || ';' FROM sqlite_master WHERE type='index';