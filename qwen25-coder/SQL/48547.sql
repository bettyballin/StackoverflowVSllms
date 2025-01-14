SELECT \n    COALESCE(C.ContactDate, 'No Entry') AS ContactDate,\n    COALESCE(C.SortName, 'No Entry') AS SortName,\n    COALESCE(A.City, 'No Entry') AS City,\n    COALESCE(C.ContactType, 'No Entry') AS ContactType,\n    COALESCE(C.Summary, 'No Entry') AS Summary\nFROM \n    ContactTable C\nLEFT JOIN \n    UserTable U ON C.UserID = U.UserID\nLEFT JOIN \n    AddressTable A ON U.AddressID = A.AddressID;