SELECT COALESCE(CONVERT(VARCHAR, someDateTime), 'No') AS someDateTimeConverted\nFROM someTable;