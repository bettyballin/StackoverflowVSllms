Imports System.Data.SqlClient\n\nModule Module1\n    Sub Main()\n        ' Create a new SqlConnectionStringBuilder and initialize it with a few name/value pairs:\n        Dim builder As New SqlConnectionStringBuilder(GetConnectionString())\n\n        ' The input connection string used the Server key, but the new connection string uses\n        ' the well-known Data Source key instead.\n        Console.WriteLine(builder.ConnectionString)\n\n        ' Pass the SqlConnectionStringBuilder an existing connection string,\n        ' and you can retrieve and modify any of the elements.\n        builder.ConnectionString = _\n            "server=http://sql.example.com;user id=******;" & _\n            "password=***********;"\n        ' Now that the connection string has been parsed, you can work with individual items.\n        Console.WriteLine(builder.Password)\n        builder.Password = "new@1Password"\n        builder.AsynchronousProcessing = True\n\n        ' You can refer to connection keys using strings, as well. When you use this technique\n        ' (the default Item property in Visual Basic, or the indexer in C#) you can specify any\n        ' synonym for the connection string key name.\n        builder("Server") = "."\n        builder("Connect Timeout") = 1000\n\n        ' The Item property is the default for the class, and setting the Item property adds the value to the \n        ' dictionary, if necessary. \n        builder.Item("Trusted_Connection") = True\n        Console.WriteLine(builder.ConnectionString)\n\n        ' Test the connection\n        TestConnection(builder.ConnectionString)\n\n        Console.WriteLine("Press Enter to finish.")\n        Console.ReadLine()\n    End Sub\n\n    Private Function GetConnectionString() As String\n        ' To avoid storing the connection string in your code,\n        ' you can retrieve it from a configuration file. \n        Return "Server=(local);Integrated Security=SSPI;" & _\n          "Initial Catalog=AdventureWorks"\n    End Function\n\n    Private Sub TestConnection(connectionString As String)\n        Using connection As New SqlConnection(connectionString)\n            Try\n                connection.Open()\n                Console.WriteLine("Connection successful.")\n            Catch ex As SqlException\n                Console.WriteLine($"An error occurred: {ex.Message}")\n            Finally\n                If connection.State = ConnectionState.Open Then\n                    connection.Close()\n                    Console.WriteLine("Connection closed.")\n                End If\n            End Try\n        End Using\n    End Sub\nEnd Module