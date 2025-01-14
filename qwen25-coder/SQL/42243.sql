SELECT \n    CompanyName,\n    CompanyAddress,\n    CompanyCity,\n    CompanyState,\n    COUNT(*) AS DuplicateCount\nFROM \n    Company\nGROUP BY \n    CASE WHEN CompanyName IS NOT NULL THEN CompanyName ELSE 'N/A' END, \n    CASE WHEN CompanyAddress IS NOT NULL THEN CompanyAddress ELSE 'N/A' END, \n    CompanyCity, \n    CompanyState\nHAVING \n    COUNT(*) > 1\nORDER BY \n    DuplicateCount DESC;