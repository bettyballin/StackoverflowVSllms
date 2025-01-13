using Oracle.ManagedDataAccess.Client;\nusing System;\nusing System.Data;\n\npublic DataSet GetCompanyAndOrders()\n{\n    string connString = "your_connection_string";\n    using (OracleConnection conn = new OracleConnection(connString))\n    {\n        using (OracleCommand cmd = new OracleCommand("GETCOMPANYANDORDERS", conn))\n        {\n            cmd.CommandType = CommandType.StoredProcedure;\n\n            // Define the parameters for the cursors\n            cmd.Parameters.Add("CompanyCursor", OracleDbType.RefCursor, ParameterDirection.Output);\n            cmd.Parameters.Add("OrdersCursor", OracleDbType.RefCursor, ParameterDirection.Output);\n\n            conn.Open();\n            using (OracleDataAdapter da = new OracleDataAdapter(cmd))\n            {\n                DataSet ds = new DataSet();\n                da.Fill(ds);\n\n                // ds.Tables[0] will contain the Companies data\n                // ds.Tables[1] will contain the Orders data\n                return ds;\n            }\n        }\n    }\n}