SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY hrl.Frn) as Row,\n     ...\n               WHERE hc.Entity_Type = 'L'  AND hrl.LicenseStatusId IN (1)\n              ) T\nWHERE T.Row >=1 and T.Row <= 20)