using Oracle.DataAccess.Client;\n\npublic void ConnectToOracle()\n{\n    string oradb = "Data Source=MyOracleDB;User Id=myUsername;Password=myPassword;";\n    using (OracleConnection conn = new OracleConnection(oradb))\n    {\n        conn.Open();\n        OracleCommand cmd = new OracleCommand\n        {\n            Connection = conn,\n            CommandText = "SELECT * FROM myTable",\n            CommandType = CommandType.Text\n        };\n\n        OracleDataReader dr = cmd.ExecuteReader();\n        while (dr.Read())\n        {\n            Console.WriteLine(dr["myColumn"].ToString());\n        }\n    }\n}