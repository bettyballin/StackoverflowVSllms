Select Field1\n    , Field2\n  --, Field3\nFrom [some_table] as ST\nInner Join [other_table] as OT\n   ON ST.PKID = OT.FKID\nWhere [this] = [that]\n   and [one_other] > 53;