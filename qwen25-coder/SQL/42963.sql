WITH RankedPatients AS (\n    SELECT \n        Id, \n        Hospital, \n        Doctor, \n        Patient,\n        ROW_NUMBER() OVER (PARTITION BY Doctor ORDER BY Id) as rn\n    FROM \n        your_table_name\n)\nSELECT \n    Id, \n    Hospital, \n    Doctor, \n    Patient\nFROM \n    RankedPatients\nWHERE \n    rn = 1;