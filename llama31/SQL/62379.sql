DECLARE @includedids BigIntList;\nINSERT INTO @includedids (Id) VALUES (25), (26);\n\nEXEC DeleteUnusedRelations @attributetypeid = 1, @productid = 1, @includedids = @includedids;