...\n    yourDataTable.Columns.Add("MyNewColumn");\n\n    foreach (DataRow row in yourDataTable.Rows) {\n        string column1Value = row["Column1"].ToString();\n        if (column1Value == "A") {\n            row["MyNewColumn"] = "G";\n        } else if (column1Value == "B") {\n            row["MyNewColumn"] = "H";\n        } else if (column1Value == "C") {\n            row["MyNewColumn"] = "I";\n        }\n    }\n    ...