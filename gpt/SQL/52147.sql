WITH UniqueC AS (\n    SELECT \n        cID, \n        cCol1, \n        cCol2, \n        col3, \n        cCol4,\n        -- Add other columns from C as needed\n        ROW_NUMBER() OVER (PARTITION BY col3 ORDER BY cID) AS rn\n    FROM \n        C\n)\nSELECT\n    A.aID, A.bID, A.aCol1, A.aCol2, A.aCol3, -- Add other columns from A as needed\n    B.bID, B.cID, B.bCol1, B.bCol2, B.bCol3, -- Add other columns from B as needed\n    UniqueC.cID, UniqueC.cCol1, UniqueC.cCol2, UniqueC.col3, UniqueC.cCol4 -- Add other columns from UniqueC as needed\nFROM\n    A\nJOIN\n    B ON A.bID = B.bID\nJOIN\n    UniqueC ON B.cID = UniqueC.cID\nWHERE\n    UniqueC.rn = 1\nORDER BY\n    A.aID;