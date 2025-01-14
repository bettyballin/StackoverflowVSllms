Imports System.Data.OleDb\n\nModule Module1\n    Sub Main()\n        Dim excelFilePath As String = "C:\Path\To\Your\ExcelFile.xls"\n        Dim connectionString As String = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=" & excelFilePath & ";Extended Properties=""Excel 8.0;HDR=Yes;IMEX=1"""\n        \n        Using connection As New OleDbConnection(connectionString)\n            connection.Open()\n\n            ' Retrieve the schema information\n            Dim schemaTable As DataTable = connection.GetOleDbSchemaTable(OleDbSchemaGuid.Tables, Nothing)\n\n            If schemaTable IsNot Nothing Then\n                ' Loop through the schema table to get sheet names\n                For Each row As DataRow In schemaTable.Rows\n                    Dim sheetName As String = row("TABLE_NAME").ToString()\n                    Console.WriteLine("Sheet Name: " & sheetName)\n                    \n                    ' Use sheetName in your SQL query\n                    Dim query As String = "SELECT * FROM [" & sheetName & "]"\n                    Dim adapter As New OleDbDataAdapter(query, connection)\n                    Dim dataTable As New DataTable()\n                    adapter.Fill(dataTable)\n                    \n                    ' Process the data (example)\n                    For Each dataRow As DataRow In dataTable.Rows\n                        ' Process each row\n                    Next\n                Next\n            End If\n\n            connection.Close()\n        End Using\n    End Sub\nEnd Module