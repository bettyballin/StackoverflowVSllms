BEGIN TRANSACTION;\n   UPDATE YourTable SET GuidColumn = SequentialGuid;\n   UPDATE ForeignKeyTable ft\n      SET ForeignGuidColumn = sm.NewSequentialGuid\n      FROM #GuidMapping sm\n      WHERE ft.ForeignGuidColumn = sm.OldGuid;\n   COMMIT TRANSACTION;