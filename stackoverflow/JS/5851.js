selectSql  = "SELECT ";\nselectSql += columns[0]._name;\n\nfor (z = 1; z < columns.size(); z++) {\n   selectSql += ", ";\n   selectSql += columns[z]._name;\n}\n\nselectSql += " FROM some-table";