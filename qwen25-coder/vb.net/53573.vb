Sub ExportQueriesToSQLFiles()\n    Dim db As DAO.Database\n    Dim qdf As DAO.QueryDef\n    Dim outputFolderPath As String\n\n    ' Set the path where you want to save the SQL files. Ensure it ends with a backslash.\n    outputFolderPath = "C:\Path\To\Your\Folder\"\n\n    Set db = CurrentDb\n    \n    For Each qdf In db.QueryDefs\n        If Not (qdf.Type And dbQsqry) = 0 Then ' Checks if the object is a standard query\n            ExportQueryToFile qdf, outputFolderPath & qdf.Name & ".sql"\n        End If\n    Next qdf\n\n    Set qdf = Nothing\n    Set db = Nothing\n    \n    MsgBox "All queries have been exported successfully."\nEnd Sub\n\nPrivate Sub ExportQueryToFile(qdf As DAO.QueryDef, filePath As String)\n    Dim txtFile As Integer\n\n    ' Open a text file for output.\n    txtFile = FreeFile()\n    \n    ' Create the file and write the SQL statement to it.\n    Open filePath For Output As #txtFile\n        Print #txtFile, qdf.SQL\n    Close #txtFile\n    \n    Debug.Print "Exported: " & filePath\nEnd Sub