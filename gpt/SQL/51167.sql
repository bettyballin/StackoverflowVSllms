DECLARE @date AS DATETIME;\n   SET @date = '1901-01-01T00:00:00';\n   SELECT @date;\n   \n   IF (@date IS NULL) \n       SELECT 'date is null'; \n   ELSE \n       SELECT 'date not null';