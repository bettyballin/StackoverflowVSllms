DECLARE @a INT\nDECLARE @sql NVARCHAR(MAX)\nDECLARE @b NVARCHAR(10)\n\nSET @a = 1\nWHILE @a < 30\nBEGIN\n    SET @b = CAST(@a AS NVARCHAR(10))\n    SET @sql = N'UPDATE source_temp SET pmt_90_day = pmt_90_day + CONVERT(money, ''trans_total_' + @b + ''')' +\n               ' WHERE CONVERT(datetime, ''effective_date_' + @b + ''') <= DATEADD(day, 90, ORSA_CHARGE_OFF_DATE)' +\n               ' AND DRC_FLAG_' + @b + ' = ''C'''\n               \n    EXEC sp_executesql @sql\n    SET @a = @a + 1\nEND