Imports System.Data.SqlClient\n\nDim connectionString As String = "YourConnectionStringHere"\nDim query As String = "SELECT foo FROM bar WHERE baz = @baz"\n\nUsing connection As New SqlConnection(connectionString)\n    Dim command As New SqlCommand(query, connection)\n    command.Parameters.AddWithValue("@baz", fuz)\n\n    connection.Open()\n    Dim reader As SqlDataReader = command.ExecuteReader()\n    ' Process the results\nEnd Using