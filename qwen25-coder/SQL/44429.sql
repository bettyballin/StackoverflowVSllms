SELECT CASE \n           WHEN (BeginningQuantity + BAdjustedQuantity) = 0 THEN 0 \n           ELSE EndingQuantity / (BeginningQuantity + BAdjustedQuantity) \n       END AS Result\nFROM YourTable;