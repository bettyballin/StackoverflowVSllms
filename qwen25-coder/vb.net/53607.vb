Sub CreateTableIfNotExists()\n    Dim db As DAO.Database\n    Dim tdf As DAO.TableDef\n    Dim tableName As String\n    \n    ' Set the name of the table you want to create\n    tableName = "history"\n    \n    ' Get the current database\n    Set db = CurrentDb\n    \n    On Error Resume Next\n        ' Try to set the TableDef object to the existing table\n        Set tdf = db.TableDefs(tableName)\n    On Error GoTo 0\n    \n    ' If tdf is Nothing, then the table does not exist and we create it\n    If tdf Is Nothing Then\n        db.Execute "CREATE TABLE " & tableName & " (ID AutoIncrement PRIMARY KEY, Field1 Text(255), Field2 Date)"\n        Debug.Print "Table " & tableName & " created."\n    Else\n        Debug.Print "Table " & tableName & " already exists."\n    End If\n    \n    ' Clean up\n    Set db = Nothing\nEnd Sub