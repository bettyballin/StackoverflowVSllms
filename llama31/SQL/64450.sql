WITH ids AS (\n  SELECT 130 AS CUSTOMER_ID UNION ALL\n  SELECT 130 AS CUSTOMER_ID UNION ALL\n  -- add more IDs here\n)\nSELECT c.NAME\nFROM CUSTOMERS c\nJOIN ids ON c.CUSTOMER_ID = ids.CUSTOMER_ID;