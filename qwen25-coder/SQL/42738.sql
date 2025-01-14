SELECT CustomerNumber, CustomerName\nFROM Customer\nWHERE User = ?\nORDER BY \n  TRY_CAST(LEFT(CustomerNumber, PATINDEX('%[^0-9]%', CustomerNumber + 'a') - 1) AS INT),\n  SUBSTRING(CustomerNumber, PATINDEX('%[^0-9]%', CustomerNumber + 'a'))