DECLARE @Date NVARCHAR(5) = '01/09';\nSELECT FORMAT(CAST('2000-' + @Date AS DATE), 'MMMM yyyy') AS formatted_date;