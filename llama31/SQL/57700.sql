WHERE \n    OrderNumber = \n    CASE \n        WHEN ISNUMERIC(@OrderNumber) = 1 THEN @OrderNumber \n        ELSE OrderNumber LIKE '%' + @OrderNumber + '%'\n    END