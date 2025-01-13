SELECT P.*\nFROM PRODUCT P\nJOIN (\n  SELECT COUNT(*) AS CustCount\n  FROM CUSTOMER\n) C ON C.CustCount > 10