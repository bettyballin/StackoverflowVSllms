DECLARE @InsertedIDs TABLE (NewID INT);\n\nINSERT INTO sometable (someval)\n    OUTPUT INSERTED.id INTO @InsertedIDs\nSELECT somefield\nFROM othertable;\n\n-- Now you can select from @InsertedIDs to get all the new IDs\nSELECT NewID FROM @InsertedIDs;