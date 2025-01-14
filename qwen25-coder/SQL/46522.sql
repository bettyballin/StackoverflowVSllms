DECLARE @tmpRes TABLE (ResourceID int, Quantity int, FormID int)\n\nINSERT INTO @tmpRes (ResourceID, Quantity, FormID)\nSELECT \n    R.value('(ID/text())[1]', 'int') AS ResourceID,\n    R.value('(Q/text())[1]', 'int') AS Quantity,\n    RESC.FormID\nFROM \n    @ResourceXML.nodes('/Resources/R') AS XMLTable(R)\nINNER JOIN \n    dbo.tblResources RESC ON XMLTable.R.value('(ID/text())[1]', 'int') = RESC.ResourceID\nWHERE \n    RESC.OrgID = @OrgID;