Imports System.Data\nImports System.Data.OleDb\n\nDim connectionString As String = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=C:\Path\To\Your\File.xls;Extended Properties=""Excel 8.0;HDR=YES;"""\nDim connection As New OleDbConnection(connectionString)\nconnection.Open()\n\nDim schemaTable As DataTable = connection.GetOleDbSchemaTable(OleDbSchemaGuid.Tables, New Object() {Nothing, Nothing, Nothing, "TABLE"})\n\nFor Each row As DataRow In schemaTable.Rows\n    Console.WriteLine(row("TABLE_NAME").ToString())\nNext\n\nconnection.Close()