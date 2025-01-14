DECLARE @objects TABLE (id INT IDENTITY(1,1), script NVARCHAR(MAX));\nINSERT INTO @objects (script) VALUES \n('CREATE TABLE TableC (...)'), \n('CREATE VIEW ViewA AS SELECT * FROM TableC'),\n('CREATE FUNCTION FunctionA(...) RETURNS ... AS BEGIN RETURN (SELECT * FROM ViewA) END'),\n('CREATE TABLE TableB (..., FOREIGN KEY (...) REFERENCES TableA(...))'),\n('CREATE TABLE TableA (..., FOREIGN KEY (...) REFERENCES TableB (...))');\n\nDECLARE @attempt INT = 1;\nWHILE EXISTS (SELECT 1 FROM @objects)\nBEGIN\n    DECLARE @script NVARCHAR(MAX);\n    DECLARE obj_cursor CURSOR FOR SELECT script FROM @objects\n    OPEN obj_cursor\n    FETCH NEXT FROM obj_cursor INTO @script\n\n    WHILE @@FETCH_STATUS = 0\n    BEGIN\n        PRINT 'Attempt #' + CAST(@attempt AS VARCHAR) + ': Executing script.';\n        BEGIN TRY\n            EXEC sp_executesql @stmt = @script;\n            DELETE FROM @objects WHERE script = @script;\n        END TRY\n        BEGIN CATCH\n            DECLARE @ErrorMessage NVARCHAR(4000);\n            DECLARE @ErrorSeverity INT;\n            DECLARE @ErrorState INT;\n\n            SELECT \n                @ErrorMessage = ERROR_MESSAGE(),\n                @ErrorSeverity = ERROR_SEVERITY(),\n                @ErrorState = ERROR_STATE();\n\n            PRINT 'An error occurred while executing the script: ' + @ErrorMessage;\n        END CATCH\n\n        FETCH NEXT FROM obj_cursor INTO @script\n    END\n\n    CLOSE obj_cursor\n    DEALLOCATE obj_cursor\n    SET @attempt = @attempt + 1\nEND