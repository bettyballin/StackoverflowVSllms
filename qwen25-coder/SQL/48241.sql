SELECT TOP 1 ParentID, CustID\nFROM cteLevelOne\nWHERE ParentID = CustID\nORDER BY (SELECT NULL) DESC -- This ensures you get one of the final results; adjust if needed for your data structure.