SELECT SUM(CASE WHEN ReceiptAmt > 0 THEN ReceiptAmt ELSE 0 END) \n     - SUM(CASE WHEN BalanceAmt > 0 THEN BalanceAmt ELSE 0 END) AS Balance\nFROM Receipt;