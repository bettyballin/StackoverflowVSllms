WHERE OrderNumber LIKE\n  CASE WHEN IsNumeric(@OrderNumber) = 1 THEN \n    @OrderNumber \n  ELSE\n    '%' + @OrderNumber\n  END