public void SyncDataSet(DataSet originalDataSet)\n{\n    // Retrieve current UI state before synchronization\n    var uiState = CaptureUIState(originalDataSet);\n\n    // Re-query database to get updated data\n    using (SqlConnection connection = new SqlConnection("your_connection_string"))\n    {\n        SqlDataAdapter adapter = new SqlDataAdapter("SELECT * FROM YourTable", connection);\n        DataSet freshDataSet = new DataSet();\n        adapter.Fill(freshDataSet);\n\n        foreach (DataTable originalTable in originalDataSet.Tables)\n        {\n            DataTable freshTable = freshDataSet.Tables[originalTable.TableName];\n            if (freshTable != null && originalTable.PrimaryKey.Length > 0)\n            {\n                // Manually merge changes detecting differences\n                foreach (DataRow row in freshTable.Rows)\n                {\n                    DataRow[] foundRows = originalTable.Select($"{originalTable.PrimaryKey[0].ColumnName}={row[originalTable.PrimaryKey[0].ColumnName]}");\n                    if (foundRows.Length > 0)\n                    {\n                        bool hasChanges = false;\n                        for (int i = 1; i < row.ItemArray.Length; i++)\n                        {\n                            if (!Equals(row[i], foundRows[0][i]))\n                            {\n                                foundRows[0][i] = row[i];\n                                hasChanges = true;\n                            }\n                        }\n\n                        if (hasChanges)\n                        {\n                            foundRows[0].AcceptChanges();\n                        }\n                    }\n                }\n            }\n        }\n    }\n\n    // Restore UI state after synchronization\n    ApplyUIState(originalDataSet, uiState);\n}\n\nprivate Dictionary<string, bool> CaptureUIState(DataSet dataSet)\n{\n    // Capture and return the current UI state (e.g., expanded rows in TreeGrid)\n    return new Dictionary<string, bool>();\n}\n\nprivate void ApplyUIState(DataSet dataSet, Dictionary<string, bool> uiState)\n{\n    // Restore the captured UI state\n}