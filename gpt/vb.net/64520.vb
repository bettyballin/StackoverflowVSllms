Sub LinkOracleViewWithPrimaryKey()\n    Dim db As DAO.Database\n    Dim tdf As DAO.TableDef\n    Dim fld As DAO.Field\n\n    ' Define connection string and table/view names\n    Dim strConnect As String\n    Dim strSourceView As String\n    Dim strDestinationTable As String\n    Dim strPrimaryKey As String\n\n    strConnect = "ODBC;DSN=YourDSN;UID=YourUserID;PWD=YourPassword;"\n    strSourceView = "YourOracleView"\n    strDestinationTable = "YourAccessTable"\n    strPrimaryKey = "YourPrimaryKeyField"\n\n    ' Open the current database\n    Set db = CurrentDb\n\n    ' Create a new table definition for the linked table\n    Set tdf = db.CreateTableDef(strDestinationTable, dbAttachSavePWD, strSourceView, strConnect)\n\n    ' Append the table definition to the TableDefs collection\n    db.TableDefs.Append tdf\n\n    ' Set the primary key field for the linked table\n    Set fld = tdf.CreateField(strPrimaryKey)\n    tdf.Indexes.Append tdf.CreateIndex("PrimaryKey").CreateField(strPrimaryKey)\n\n    ' Refresh the table definitions collection\n    db.TableDefs.Refresh\n\n    ' Clean up\n    Set fld = Nothing\n    Set tdf = Nothing\n    Set db = Nothing\n\n    MsgBox "Linked table created successfully with primary key set."\nEnd Sub