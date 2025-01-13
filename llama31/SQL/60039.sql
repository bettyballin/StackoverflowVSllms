FROM (\n  SELECT * FROM AR_InvoiceHistoryHeader\n  WHERE SalespersonNo = 'SMC' AND InvoiceDate >= @p_dr AND InvoiceDate <= @p_d2\n) AS filtered_header\nINNER JOIN AR_InvoiceHistoryDetail ON filtered_header.InvoiceNo = AR_InvoiceHistoryDetail.InvoiceNo\nINNER JOIN IM1_InventoryMasterfile ON AR_InvoiceHistoryDetail.ItemCode = IM1_InventoryMasterfile.ItemNumber