for (int i = 0; i < rowCount; i++) {\n    if (table[i].data == specificValue) {\n        runStoredProcedure(table[i].userID);\n    }\n}