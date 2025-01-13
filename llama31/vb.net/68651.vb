Imports System.Xml\nImports System.Data.SqlClient\n\nDim xmlDoc As New XmlDocument()\nxmlDoc.Load("path/to/your/xmlfile.xml")\n\nDim connectionString As String = "Your SQL Server connection string"\nDim dbConnection As New SqlConnection(connectionString)\ndbConnection.Open()\n\nDim xmlReader As New XmlReader(xmlDoc)\nWhile xmlReader.Read()\n    If xmlReader.NodeType = XmlNodeType.Element Then\n        Dim elementName As String = xmlReader.Name\n        Dim elementValue As String = xmlReader.Value\n\n        ' Create a SqlCommand to insert the data\n        Dim sqlCommand As New SqlCommand("INSERT INTO YourTable (ColumnName) VALUES (@value)", dbConnection)\n        sqlCommand.Parameters.AddWithValue("@value", elementValue)\n\n        ' Execute the command\n        sqlCommand.ExecuteNonQuery()\n    End If\nEnd While\n\nxmlReader.Close()\ndbConnection.Close()