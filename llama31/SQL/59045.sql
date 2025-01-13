CREATE FUNCTION soundex(@value VARCHAR(50))\nRETURNS VARCHAR(4)\nAS\nBEGIN\n  DECLARE @soundex VARCHAR(4)\n  SET @soundex = \n    UPPER(LEFT(@value, 1)) + \n    REPLACE(REPLACE(REPLACE(SUBSTRING(@value, 2, LEN(@value)), '[aeiouhwy]', ''), '[bfpv]', '1'), '[cgjkqsxz]', '2')\n  RETURN @soundex\nEND;\n\nSELECT \n  a.value, \n  b.value\nFROM your_table a\nJOIN your_table b ON soundex(a.value) = soundex(b.value) AND a.value <> b.value;