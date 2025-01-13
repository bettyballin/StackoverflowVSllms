try\n{\n    using (SqlConnection conn = Connection())\n    {\n        conn.Open();\n\n        using (SqlTransaction sqlTrans = conn.BeginTransaction())\n        {\n            try\n            {\n                using (SqlCommand cmd1 = new SqlCommand("Stored_Proc_1", conn, sqlTrans))\n                {\n                    cmd1.CommandType = CommandType.StoredProcedure;\n                    cmd1.ExecuteNonQuery();\n                }\n\n                using (SqlCommand cmd2 = new SqlCommand("Stored_Proc_2", conn, sqlTrans))\n                {\n                    cmd2.CommandType = CommandType.StoredProcedure;\n                    cmd2.ExecuteNonQuery();\n                }\n\n                sqlTrans.Commit();\n            }\n            catch\n            {\n                try\n                {\n                    sqlTrans.Rollback();\n                }\n                catch\n                {\n                    // Handle any errors that may have occurred on the server that would cause the rollback to fail,\n                    // such as a closed connection.\n                }\n\n                throw;\n            }\n        }\n\n        conn.Close();\n    }\n}\ncatch (SqlException ex)\n{\n    // Exception handling and logging code here...\n}