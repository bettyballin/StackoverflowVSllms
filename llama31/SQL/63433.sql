declare @value decimal(18,6)\nset @value = 123.456\n\nselect CAST(@value * 100 AS INT) / 100.0