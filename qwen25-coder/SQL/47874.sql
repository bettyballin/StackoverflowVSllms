-- Example of creating tables for shards with a simple modulo-based distribution\nCREATE TABLE user_data_0 LIKE users_template;\nCREATE TABLE user_data_1 LIKE users_template;\n-- Repeat for desired number of shards\n\n-- Function to determine shard based on user ID\nDELIMITER //\nCREATE FUNCTION GetShardId(userId INT) RETURNS INT DETERMINISTIC\nBEGIN\n    DECLARE numShards INT DEFAULT 256;\n    RETURN MOD(userId, numShards);\nEND//\nDELIMITER ;\n\n-- Example usage in an insert statement\nINSERT INTO user_data_{GetShardId(new_user_id)} (user_id, data) VALUES (new_user_id, 'some_data');