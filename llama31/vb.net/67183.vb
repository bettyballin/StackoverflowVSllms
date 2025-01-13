Imports System.Data.Odbc\n\nModule Module1\n    Sub Main()\n        ' Create an ODBC connection string\n        Dim connectionString As String = "DRIVER={MySQL ODBC 5.1 Driver};SERVER=localhost;DATABASE=mydatabase;UID=myusername;PWD=mypassword;"\n\n        ' Create an ODBC command\n        Dim command As New OdbcCommand("SELECT * FROM mytable", New OdbcConnection(connectionString))\n\n        ' Open the connection and execute the command\n        command.Connection.Open()\n        Dim reader As OdbcDataReader = command.ExecuteReader()\n\n        ' Read the data\n        While reader.Read()\n            Console.WriteLine(reader("column1").ToString() & " - " & reader("column2").ToString())\n        End While\n\n        ' Close the reader and connection\n        reader.Close()\n        command.Connection.Close()\n    End Sub\nEnd Module