DECLARE @Ids IdTableType;\n\nINSERT INTO @Ids (Id)\nVALUES (1), (2), (3); -- Add your IDs here\n\nEXEC DeleteExceptIds @Ids;