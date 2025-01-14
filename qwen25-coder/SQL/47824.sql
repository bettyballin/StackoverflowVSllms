DECLARE @url varchar(250)\nDECLARE @httpResult int\nDECLARE @obj int\n\n-- URL of the web service\nSET @url = 'https://example.com/api/data'\n\n-- Create an HTTP object to make GET request\nEXEC @httpResult = sp_OACreate 'MSXML2.XMLHTTP', @obj OUT\nIF @httpResult <> 0 PRINT 'Failed to create HTTP Object'\nELSE \nBEGIN\n    -- Open connection\n    EXEC @httpResult = sp_OAMethod @obj, 'open', NULL, 'GET', @url, false\n    IF @httpResult <> 0 PRINT 'Failed to open URL'\n    ELSE\n    BEGIN\n        -- Send request\n        EXEC @httpResult = sp_OAMethod @obj, 'send'\n\n        DECLARE @responseText nvarchar(max)\n        -- Get the response text\n        EXEC @httpResult = sp_OAGetProperty @obj, 'responseText', @responseText OUT\n\n        PRINT @responseText\n\n        -- Clean up\n        EXEC sp_OADestroy @Obj \n    END\nEND