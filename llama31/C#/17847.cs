foreach (DataGridViewRow row in grid.Rows)\n{\n    foreach (DataGridViewCell cell in row.Cells)\n    {\n        if (cell.Value == myValue)\n        {\n            // Do Something useful\n            goto ExitLoops;\n        }\n    }\n}\nExitLoops:\n// Continue execution here