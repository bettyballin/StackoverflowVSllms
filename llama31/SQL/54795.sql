DECLARE\n  index_count NUMBER;\nBEGIN\n  SELECT COUNT(*) INTO index_count \n  FROM ALL_IND_COLUMNS \n  WHERE TABLE_NAME = 'YOUR_TABLE_NAME' \n    AND COLUMN_NAME = 'YOUR_COLUMN_NAME';\n\n  IF index_count = 0 THEN\n    EXECUTE IMMEDIATE 'CREATE INDEX idx_YOUR_COLUMN_NAME ON YOUR_TABLE_NAME (YOUR_COLUMN_NAME)';\n  END IF;\nEND;\n/