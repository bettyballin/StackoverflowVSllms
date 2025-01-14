SET ANSI_NULLS ON\nGO\nSET QUOTED_IDENTIFIER ON\nGO\n\nALTER FUNCTION [dbo].[IP4toBIGINT](\n    @ip4 varchar(15)\n) \nRETURNS bigint\nWITH SCHEMABINDING\nAS\nBEGIN\n    DECLARE @oct1 bigint, @oct2 bigint, @oct3 bigint, @oct4 bigint;\n    DECLARE @Result bigint;\n\n    -- Split the IP address into its components using CHARINDEX and SUBSTRING\n    SET @oct1 = CAST(SUBSTRING(@ip4, 1, CHARINDEX('.', @ip4) - 1) AS tinyint);\n    SET @oct2 = CAST(SUBSTRING(@ip4, CHARINDEX('.', @ip4) + 1, \n        CHARINDEX('.', @ip4, CHARINDEX('.', @ip4) + 1) - CHARINDEX('.', @ip4) - 1) AS tinyint);\n    SET @oct3 = CAST(SUBSTRING(@ip4, CHARINDEX('.', @ip4, CHARINDEX('.', @ip4) + 1) + 1, \n        CHARINDEX('.', @ip4, CHARINDEX('.', @ip4, CHARINDEX('.', @ip4) + 1) + 1) - \n        CHARINDEX('.', @ip4, CHARINDEX('.', @ip4) + 1) - 1) AS tinyint);\n    SET @oct4 = CAST(SUBSTRING(@ip4, CHARINDEX('.', @ip4, CHARINDEX('.', @ip4, CHARINDEX('.', @ip4) + 1) + 1) + 1, \n        LEN(@ip4) - CHARINDEX('.', @ip4, CHARINDEX('.', @ip4, CHARINDEX('.', @ip4) + 1) + 1)) AS tinyint);\n\n    -- Combine all values\n    SET @Result = @oct1 * 256*256*256 + @oct2 * 256*256 + @oct3 * 256 + @oct4;\n    \n    RETURN @Result;\nEND