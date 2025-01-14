Imports System.Data.SqlClient\nImports System.Xml\n\nSub ImportXmlToDatabase(xmlFilePath As String, connectionString As String)\n    ' Load the XML document\n    Dim xmlDoc As New XmlDocument()\n    xmlDoc.Load(xmlFilePath)\n\n    ' Establish a connection to the SQL Server database\n    Using connection As New SqlConnection(connectionString)\n        connection.Open()\n\n        ' Iterate through each record in the XML file\n        For Each node As XmlNode In xmlDoc.DocumentElement.SelectNodes("YourXmlRowNodeName")\n            Dim insertQuery As String = "INSERT INTO YourTableName (Column1, Column2) VALUES (@Value1, @Value2)"\n            \n            Using command As New SqlCommand(insertQuery, connection)\n                ' Set parameters to prevent SQL injection\n                command.Parameters.AddWithValue("@Value1", node.SelectSingleNode("YourXmlColumnName1").InnerText)\n                command.Parameters.AddWithValue("@Value2", node.SelectSingleNode("YourXmlColumnName2").InnerText)\n\n                ' Execute the insert query\n                command.ExecuteNonQuery()\n            End Using\n        Next\n\n        connection.Close()\n    End Using\nEnd Sub\n\n' Usage example:\nDim xmlFilePath As String = "C:\path\to\your\file.xml"\nDim connectionString As String = "Server=YourServerName;Database=YourDatabaseName;Integrated Security=True;"\nImportXmlToDatabase(xmlFilePath, connectionString)