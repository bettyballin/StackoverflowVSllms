Microsoft.SqlServer.Management.Smo.Server srv = new Microsoft.SqlServer.Management.Smo.Server("Server");\n\n        Microsoft.SqlServer.Management.Smo.Database db = srv.Databases["DB_Name"];\n\n        // Set scripting options as needed using a ScriptingOptions object.\n        Microsoft.SqlServer.Management.Smo.ScriptingOptions so = new ScriptingOptions();\n        so.AllowSystemObjects = false;\n        so.ScriptDrops = false;\n        so.Indexes = true;\n        so.ClusteredIndexes = true;\n        so.PrimaryObject = true;\n        so.SchemaQualify = true;\n        so.IncludeIfNotExists = false;\n        so.Triggers = true;\n\n        System.Collections.Specialized.StringCollection sc = new System.Collections.Specialized.StringCollection();\n        StringBuilder sb = new StringBuilder();\n\n        foreach (Table item in db.Tables)\n            if (!item.IsSystemObject)\n            {\n                sc = item.Script(so);\n                foreach (string s in sc)\n                    sb.Append(s);\n            }\n\n        foreach (StoredProcedure item in db.StoredProcedures)\n            if (!item.IsSystemObject)\n                if (!item.IsSystemObject)\n                {\n                    sc = item.Script(so);\n                    foreach (string s in sc)\n                        sb.Append(s);\n                }\n\n        foreach (UserDefinedFunction item in db.UserDefinedFunctions)\n            if (!item.IsSystemObject)\n                if (!item.IsSystemObject)\n                {\n                    sc = item.Script(so);\n                    foreach (string s in sc)\n                        sb.Append(s);\n                }\n\n        foreach (Trigger item in db.Triggers)\n            if (!item.IsSystemObject)\n                if (!item.IsSystemObject)\n                {\n                    sc = item.Script(so);\n                    foreach (string s in sc)\n                        sb.Append(s);\n                }\n\n\n        //sb.GetHashCode();\n        // For a better hash do this.\n        System.Security.Cryptography.MD5CryptoServiceProvider hashProvider = new System.Security.Cryptography.MD5CryptoServiceProvider();\n\n        byte[] hashData = hashProvider.ComputeHash(ASCIIEncoding.ASCII.GetBytes(sb.ToString()));