CREATE TABLE #results (id INT, created_in_variant INT)\n\nINSERT INTO #results\nEXEC your_stored_procedure\n\nUPDATE a\nSET a.created_in_variant = r.created_in_variant\nFROM [dbo].[alerts] a\nJOIN #results r ON a.id = r.id