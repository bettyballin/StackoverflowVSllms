UPDATE tblStarting_Data\nSET CustomerID = (\n  SELECT CustomerID \n  FROM qryIDPerCustomer \n  WHERE TEMPCustomer = tblStarting_Data.TEMPCustomer\n)