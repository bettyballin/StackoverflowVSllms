public static string GetCommandTextWithParameters(OracleCommand command)\n{\n    string commandText = command.CommandText;\n    foreach (OracleParameter parameter in command.Parameters)\n    {\n        string parameterValue = parameter.Value.ToString();\n        if (parameter.OracleDbType == OracleDbType.Date)\n        {\n            parameterValue = $"TO_DATE('{parameterValue}', 'yyyy/mm/dd')";\n        }\n        commandText = commandText.Replace($":{parameter.ParameterName}", parameterValue);\n    }\n    return commandText;\n}