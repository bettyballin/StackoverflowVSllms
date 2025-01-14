TRANSFORM \n    Sum([Amount]) AS Total_Sales\nSELECT \n    [Product]\nFROM \n    Sales\nGROUP BY \n    [Product]\nPIVOT \n    [Month] IN ('January', 'February', 'March');  -- Specify the months you need here\n\n-- To replace nulls with zeros, use an IIF or NZ function in the TRANSFORM part:\nTRANSFORM \n    NZ(Sum([Amount]), 0) AS Total_Sales\nSELECT \n    [Product]\nFROM \n    Sales\nGROUP BY \n    [Product]\nPIVOT \n    [Month] IN ('January', 'February', 'March');