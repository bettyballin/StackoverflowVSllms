Imports System.Data.SqlClient\n\nDim connectionStringBuilder As New SqlConnectionStringBuilder()\nconnectionStringBuilder.DataSource = "your_server_name"\nconnectionStringBuilder.InitialCatalog = "your_database_name"\nconnectionStringBuilder.IntegratedSecurity = False\nconnectionStringBuilder.UserID = "NT_domain\username" ' replace with user-provided username\nconnectionStringBuilder.Password = "password" ' replace with user-provided password\n\nDim connectionString As String = connectionStringBuilder.ToString()\nDim connection As New SqlConnection(connectionString)\n\nTry\n    connection.Open()\n    ' if we reach this point, the credentials are valid\nCatch ex As SqlException\n    ' handle invalid credentials error\nFinally\n    connection.Close()\nEnd Try