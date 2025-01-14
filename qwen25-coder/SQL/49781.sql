WITH RankedBills AS (\n    SELECT BillId,\n           Estimated,\n           InvoiceDate,\n           LAG(Estimated) OVER (ORDER BY BillId DESC) AS PreviousEstimated\n    FROM Bills\n)\nSELECT BillId\nFROM RankedBills\nWHERE Estimated = 1 AND PreviousEstimated = 1;