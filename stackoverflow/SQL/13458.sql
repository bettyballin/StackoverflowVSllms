CREATE FUNCTION [dbo].[InitCap] ( @InputString varchar(4000) ) \nRETURNS VARCHAR(4000)\nAS\nBEGIN\n\nDECLARE @Index          INT\nDECLARE @Char           CHAR(1)\nDECLARE @PrevChar       CHAR(1)\nDECLARE @OutputString   VARCHAR(255)\n\nSET @OutputString = LOWER(@InputString)\nSET @Index = 1\n\nWHILE @Index <= LEN(@InputString)\nBEGIN\n    SET @Char     = SUBSTRING(@InputString, @Index, 1)\n    SET @PrevChar = CASE WHEN @Index = 1 THEN ' '\n                         ELSE SUBSTRING(@InputString, @Index - 1, 1)\n                    END\n\n    IF @PrevChar IN (' ', ';', ':', '!', '?', ',', '.', '_', '-', '/', '&', '''', '(')\n    BEGIN\n        IF @PrevChar != '''' OR UPPER(@Char) != 'S'\n            SET @OutputString = STUFF(@OutputString, @Index, 1, UPPER(@Char))\n    END\n\n    SET @Index = @Index + 1\nEND\n\nRETURN @OutputString\n\nEND\nGO