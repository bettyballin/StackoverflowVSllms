class XmlCsvImport\n{\n    public void ImportData(string xmlData, ConnectionStringSettings connectionSettings)\n    {\n        DbProviderFactory providerFactory = DbProviderFactories.GetFactory(connectionSettings.ProviderName);\n\n        IDbConnection connection = providerFactory.CreateConnection();\n        connection.ConnectionString = connectionSettings.ConnectionString;\n\n        // TODO: Begin transaction\n\n        XmlDocument doc = new XmlDocument();\n        doc.LoadXml(xmlData);\n\n        foreach (XmlNode tableNode in doc.SelectNodes("/transaction/table"))\n        {\n            IDbCommand command = CreatCommand(connection, tableNode);\n\n            foreach (XmlNode rowNode in tableNode.SelectNodes("data/row"))\n            {\n                string[] values = GetRowValues(rowNode);\n\n                if (values.Length != command.Parameters.Count)\n                {\n                    // TODO: Log bad row\n                    continue;\n                }\n\n                this.FillCommand(command, values);\n                command.ExecuteNonQuery();\n            }\n        }\n\n        // TODO: Commit transaction\n    }\n\n    private IDbCommand CreatCommand(IDbConnection connection, XmlNode tableNode)\n    {\n        string tableName = tableNode.Attributes["name"].Value;\n\n        IDbCommand command = connection.CreateCommand();\n        command.Connection = connection;\n        command.CommandType = CommandType.Text;\n\n        XmlNodeList fieldNodes = tableNode.SelectNodes("fields/field");\n\n        List<string> fieldNameList = new List<string>(fieldNodes.Count);\n\n        foreach (XmlNode fieldNode in tableNode.SelectNodes("fields/field"))\n        {\n            string fieldName = fieldNode.Attributes["name"].Value;\n            int fieldType = Int32.Parse(fieldNode.Attributes["type"].Value);\n            int fieldSize = Int32.Parse(fieldNode.Attributes["size"].Value);\n\n            IDbDataParameter param = command.CreateParameter();\n            param.ParameterName = String.Concat("@", fieldNode.Attributes["name"]);\n            param.Size = fieldSize;\n            param.DbType = (DbType)fieldType; // NOTE: this may not be so easy\n            command.Parameters.Add(param);\n\n            fieldNameList.Add(fieldName);\n        }\n\n        string[] fieldNames = fieldNameList.ToArray();\n\n        StringBuilder commandBuilder = new StringBuilder();\n        commandBuilder.AppendFormat("INSERT INTO [{0}] (", tableName);\n\n        string columnNames = String.Join("], [", fieldNames);\n        string paramNames = String.Join(", @", fieldNames);\n\n        command.CommandText = String.Concat(\n            "INSERT INTO [", tableName, "] ([",\n            columnNames,\n            "]) VALUES (@",\n            paramNames,\n            ")"\n            );\n\n        return command;\n    }\n\n    private string[] GetRowValues(XmlNode row)\n    {\n        List<string> values = new List<string>();\n\n        foreach (XmlNode child in row.ChildNodes)\n        {\n            if (child.NodeType == XmlNodeType.Text ||\n                child.NodeType == XmlNodeType.CDATA)\n            {\n                values.Add(child.Value);\n            }\n        }\n\n        return values.ToArray();\n    }\n\n    private void FillCommand(IDbCommand command, string[] values)\n    {\n        for (int i = 0; i < values.Length; i++)\n        {\n            IDbDataParameter param = (IDbDataParameter)command.Parameters[i];\n            param.Value = values[i]; // TODO: Convert to correct data type\n        }\n    }