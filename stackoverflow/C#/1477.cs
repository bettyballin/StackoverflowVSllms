while (myOracleDataReader.Read())\n{\n    int x = myOracleDataReader.GetOracleDecimal(0).ToInt32();\n}