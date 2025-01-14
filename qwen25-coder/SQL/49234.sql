WITH RankedInvoices AS (\n    SELECT \n        chargeId, \n        chargeType, \n        serviceMonth,\n        ROW_NUMBER() OVER (PARTITION BY chargeId, chargeType ORDER BY serviceMonth DESC) as rn\n    FROM invoice\n)\nSELECT \n    chargeId, \n    chargeType, \n    serviceMonth\nFROM RankedInvoices\nWHERE rn = 1;