public string GetRecordsAsJson()\n{\n    List<Record> records = GetRecordsFromDatabase();\n    JavaScriptSerializer jsSerializer = new JavaScriptSerializer();\n    string json = jsSerializer.Serialize(records);\n    return json;\n}