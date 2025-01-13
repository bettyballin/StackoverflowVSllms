DECLARE @columns VARCHAR(2000)\n    SELECT @columns = STUFF(( SELECT DISTINCT TOP 100 PERCENT\n    '],[' + c.name\n    FROM currency AS c\n    ORDER BY '],[' + c.name\n    FOR XML PATH('')\n    ), 1, 2, '') + ']'\n\n    DECLARE @query NVARCHAR(4000)\n    SET @query = N'SELECT UserName, ' + @columns +\n    'FROM \n    (SELECT u.Name AS UserName, c.name AS CurrencyName, a.Amount\n    FROM Accounts AS a WITH(NOLOCK)\n    JOIN Users u WITH(NOLOCK) ON a.user_id = u.user_id\n    JOIN Currency c WITH(NOLOCK) ON a.currency_id = c.currency_id\n    ) p\n    PIVOT\n    (\n    SUM (p.Amount)\n    FOR p.CurrencyName IN\n    ( '+ @columns +')\n    ) AS pvt\n    ORDER BY UserName'\n\nEXECUTE(@query)