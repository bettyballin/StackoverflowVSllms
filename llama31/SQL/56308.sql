WHERE date_column >= CONVERT(DATE, CONVERT(VARCHAR, @year) + '-' + CONVERT(VARCHAR, @month) + '-01')\n  AND date_column < DATEADD(MONTH, 1, CONVERT(DATE, CONVERT(VARCHAR, @year) + '-' + CONVERT(VARCHAR, @month) + '-01'))