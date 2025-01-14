-- Add a specific column if it doesn't exist and not indexed for performance issues\nALTER TABLE YourTableName ADD ImportFlag BIT NULL;\n\n-- Modify your trigger to check this flag before executing sensitive logic\nCREATE TRIGGER YourTableName_YourTriggerName\nON YourTableName\nAFTER INSERT, UPDATE -- as required by your original trigger definition\nAS\nBEGIN\n    SET NOCOUNT ON;\n    \n    IF NOT EXISTS (SELECT 1 FROM inserted WHERE ImportFlag = 1)\n    BEGIN\n        -- Original logic...\n    END\nEND;\n\n-- During your import process, set the flag to skip the trigger's special logic\nINSERT INTO YourTableName (Columns, ImportFlag) VALUES (Values, 1);\n\n-- Remember to clean up or remove the column if it's no longer needed\nALTER TABLE YourTableName DROP COLUMN ImportFlag;