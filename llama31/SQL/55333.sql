SELECT \n    Field1\n    , Field2\n    -- , Field3\nFROM \n    [some_table] AS ST\nINNER JOIN \n    [other_table] AS OT\n    ON ST.PKID = OT.FKID\nWHERE \n    [this] = [that]\n    AND [one_other] > 53;