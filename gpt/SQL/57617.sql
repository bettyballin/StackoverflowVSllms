WITH RankedClients AS (\n    SELECT \n        CLIENT.*, \n        OFFICE.*, \n        OFFICE_MIS.*, \n        ROW_NUMBER() OVER (PARTITION BY CLIENT.ID ORDER BY OFFICE_MIS.TABLE_CODE) AS rn\n    FROM \n        CLIENT\n    LEFT OUTER JOIN \n        OFFICE ON CLIENT.CASE_OFFICE = OFFICE.TABLE_CODE\n    LEFT OUTER JOIN \n        OFFICE_MIS ON CLIENT.REFERRAL_OFFICE = OFFICE_MIS.TABLE_CODE\n)\nSELECT \n    * \nFROM \n    RankedClients\nWHERE \n    rn = 1;