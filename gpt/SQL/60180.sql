CREATE PROCEDURE SampleProcedure\nAS\nBEGIN\n    -- Your logic here\n\n    -- Log a message\n    INSERT INTO LogTable (LogMessage) VALUES ('Sample log message');\n\n    -- More logic here\nEND;