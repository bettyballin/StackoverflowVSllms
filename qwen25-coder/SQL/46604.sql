-- Assuming NULL values represent unspecified keys\nSELECT *\nFROM invitations \nWHERE email = 'user@example.com' \nAND (key1 IS NOT DISTINCT FROM 'value1' OR key1 IS NULL)\nAND (key2 IS NOT DISTINCT FROM 'value2' OR key2 IS NULL)\nAND (key3 IS NOT DISTINCT FROM 'value3' OR key3 IS NULL);