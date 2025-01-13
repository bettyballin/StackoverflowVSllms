static public void addTableA(string table, bool addtoDataSet)\n{\n    dataconnectionA.Open();\n    datatableA = new DataTable(table);\n\n    try\n    {\n        OleDbCommand commandselectA = new OleDbCommand("SELECT * FROM [" + table + "]", dataconnectionA);\n        adapterA.SelectCommand = commandselectA;\n        adapterA.Fill(datatableA);\n\n        // Set the primary key column\n        DataColumn primaryKeyColumn = datatableA.Columns[0];\n        datatableA.PrimaryKey = new DataColumn[] { primaryKeyColumn };\n    }\n    catch\n    {\n        Logging.updateLog("Error: Tried to get " + table + " from DataSetA. Table doesn't exist!", true, false, false);\n    }\n\n    if (addtoDataSet == true)\n    {\n        datasetA.Tables.Add(datatableA);\n        Logging.updateLog("Added DataTableA: " + datatableA.TableName.ToString() + " Successfully!", false, false, false);\n    }\n\n    dataconnectionA.Close();\n}\n\nstatic public void addTableB(string table, bool addtoDataSet)\n{\n    dataconnectionB.Open();\n    datatableB = new DataTable(table);\n\n    try\n    {\n        OleDbCommand commandselectB = new OleDbCommand("SELECT * FROM [" + table + "]", dataconnectionB);\n        adapterB.SelectCommand = commandselectB;\n        adapterB.Fill(datatableB);\n\n        // Set the primary key column\n        DataColumn primaryKeyColumn = datatableB.Columns[0];\n        datatableB.PrimaryKey = new DataColumn[] { primaryKeyColumn };\n    }\n    catch\n    {\n        Logging.updateLog("Error: Tried to get " + table + " from DataSetB. Table doesn't exist!", true, false, false);\n    }\n\n    if (addtoDataSet == true)\n    {\n        datasetB.Tables.Add(datatableB);\n        Logging.updateLog("Added DataTableB: " + datatableB.TableName.ToString() + " Successfully!", false, false, false);\n    }\n\n    dataconnectionB.Close();\n}