CREATE TRIGGER UpdateLastUpdateTimestamp\nBEFORE UPDATE ON YourTableName\nFOR EACH ROW\nBEGIN\n    SET NEW.LastUpdatedDate = NOW();\nEND;\n\nCREATE TRIGGER InsertLastUpdateTimestamp\nBEFORE INSERT ON YourTableName\nFOR EACH ROW\nBEGIN\n    SET NEW.LastUpdatedDate = NOW();\nEND;