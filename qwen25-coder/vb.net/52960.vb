Dim connectionString As String = "Data Source=2UA72518QY\SQLEXPRESS;Integrated Security=True;Pooling=False;Initial Catalog='Foo_Content'"\n\nDim ds As New DataSet\nds.ReadXml(Server.MapPath("xml/FOOSECTIONS.XML"))\n\n' Ensure you are getting the correct table from the dataset\nDim sourceData As DataTable = ds.Tables(0) ' Assuming the data is in the first table\n\nUsing destinationConnection As SqlConnection = New SqlConnection(connectionString)\n    destinationConnection.Open()\n\n    Using bulkCopy As SqlBulkCopy = New SqlBulkCopy(destinationConnection)\n        ' Debugging: Output column names to check they are as expected\n        For Each col As DataColumn In sourceData.Columns\n            Response.Write($"Column in DataTable: {col.ColumnName}<br>")\n        Next\n\n        ' Map only the columns that exist in both the DataTable and the destination table.\n        bulkCopy.ColumnMappings.Add("COURSENAME", "COURSENAME")\n        bulkCopy.ColumnMappings.Add("COURSETITLE", "COURSETITLE")\n        bulkCopy.ColumnMappings.Add("COURSEDESC", "COURSEDESC")\n        ' The mapping below seems incorrect, ensure it matches your source and destination column names\n        bulkCopy.ColumnMappings.Add("COURSEFACULTY", "COURSEFACULTY") ' Adjusted from COURSETITLE to COURSEFACULTY or correct accordingly\n        bulkCopy.ColumnMappings.Add("COURSETERM", "COURSETERM")\n\n        bulkCopy.DestinationTableName = "RISDCourseData"\n\n        Try\n            bulkCopy.WriteToServer(sourceData)\n        Catch ex As Exception\n            Response.Write($"Error: {ex.Message}")\n        Finally\n            ' SqlBulkCopy and SqlConnection are closed automatically in the Using block.\n        End Try\n    End Using\nEnd Using