CREATE PROCEDURE ExecuteRemoteExe\nAS\nBEGIN\n    DECLARE @Data TABLE (Response NVARCHAR(1024));\n    INSERT INTO @Data\n    EXEC xp_cmdshell 'echo RunExe | openssl s_client -connect 127.0.0.1:5001';\n\n    SELECT Response FROM @Data;\nEND;