DECLARE @TimeID INT;\n     SET @TimeID = (SELECT ID FROM DimensionTable WHERE DateTime = ?);