Dim s = From row In context.Table\n        Where UCase(row.Name) = "TEST"\n        Select row