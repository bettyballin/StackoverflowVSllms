using (ISession session = SessionFactory.GetCurrentSession())\n{\n    IDbCommand command = session.Connection.CreateCommand();\n    command.CommandText = "your_sql_statement_here";\n    command.ExecuteNonQuery();\n}