SELECT \n    SUM(ReceiptAmt) - \n    SUM(BalanceAmt) \nFROM \n    (SELECT * FROM Receipt WHERE ReceiptAmt > 0) AS PositiveReceipts