DECLARE @RowsAffected INT;\nEXEC MyProcedure @RowsAffected OUTPUT;\nSELECT @RowsAffected AS RowsAffected;