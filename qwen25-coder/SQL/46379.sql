FROM  "AR_InvoiceHistoryDetail" "AR_InvoiceHistoryDetail"\n   WHERE EXISTS (\n       SELECT 1 \n       FROM "AR_InvoiceHistoryHeader" "AR_InvoiceHistoryHeader"\n       INNER JOIN "IM1_InventoryMasterfile" "IM1_InventoryMasterfile"\n       ON "AR_InvoiceHistoryDetail"."ItemCode" = "IM1_InventoryMasterfile"."ItemNumber"\n       WHERE "AR_InvoiceHistoryDetail"."InvoiceNo" = "AR_InvoiceHistoryHeader"."InvoiceNo"\n       AND "AR_InvoiceHistoryHeader"."SalespersonNo" = 'SMC'\n       AND "AR_InvoiceHistoryHeader"."InvoiceDate" >= @p_dr\n       AND "AR_InvoiceHistoryHeader"."InvoiceDate" <= @p_d2\n   )