private void updateRecord(TableName updatedRecord)\n{\n    using (context db = new context())\n    {\n        TableName originalRecord = db.TableName.Single(r => r.PrimaryKey == updatedRecord.PrimaryKey);\n        originalRecord.Field1 = updatedRecord.Field1;\n        originalRecord.Field2 = updatedRecord.Field2;\n        // ...\n        db.SubmitChanges();\n    }\n}