CREATE FUNCTION fGetTransactionStatusLog\n(\n    @TransactionID  int\n)\nRETURNS varchar(8000) AS  \nBEGIN \n    DECLARE @output xml\n\n    SELECT @output = (\n        SELECT RTRIM(CAST(Stamp AS varchar(30))) + ': ' + NewStatusID + ' by ' + ISNULL(FirstName + ' ' + LastName, '')  + CHAR(13) + CHAR(10) +\n               CASE WHEN Notes IS NOT NULL THEN '---' + Notes +  CHAR(13) + CHAR(10) ELSE '' END\n        FROM TransactionStatusChanges tsc\n        LEFT JOIN Users us ON tsc.UserID = us.UserID\n        WHERE TransactionID = @TransactionID\n        ORDER BY StatusNum\n        FOR XML PATH(''), TYPE\n    )\n\n    RETURN STUFF(CAST(@output AS varchar(max)), 1, 0, '')\nEND