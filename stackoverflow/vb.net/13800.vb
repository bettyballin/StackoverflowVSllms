Public Function fnReconnectODBC( _\n    Optional bForceReconnect As Boolean _\n    ) As Boolean\n    ' Comments  :\n    ' Parameters: bForceReconnect -\n    ' Returns   : Boolean -\n    ' Modified  :\n    ' --------------------------------------------------'\n\n    On Error GoTo Err_fnReconnectODBC\n\n    Dim db As DAO.Database\n    Dim rs As DAO.Recordset\n    Dim tdf As DAO.TableDef\n    Dim sPrimaryKeyName As String\n    Dim sPrimaryKeyField As String\n    Dim sLocalTableName As String\n    Dim strConnect As String\n    Dim varRet As Variant\n\n    Dim con As ADODB.Connection\n    Dim rst As ADODB.Recordset\n    Dim sSQL As String\n\n    If IsMissing(bForceReconnect) Then\n\n        bForceReconnect = False\n\n    End If\n\n    sSQL = "SELECT rtblODBC.LocalTableName, MSysObjects.Name, MSysObjects.ForeignName, rtblODBC.SourceTableName, MSysObjects.Connect, rtblODBC.ConnectString " _\n         & "FROM MSysObjects RIGHT JOIN rtblODBC ON MSysObjects.Name = rtblODBC.LocalTableName " _\n         & "WHERE (((rtblODBC.ConnectString)<>'ODBC;' & [Connect]));"\n\n    Set con = Access.CurrentProject.Connection\n    Set rst = New ADODB.Recordset\n\n    rst.Open sSQL, con, adOpenDynamic, adLockOptimistic\n\n        'Test the recordset to see if any tables in rtblODBC (needed tables) are missing from the MSysObjects (actual tables)\n        If rst.BOF And rst.EOF And bForceReconnect = False Then\n\n            'No missing tables identified\n            fnReconnectODBC = True\n\n        Else\n\n            'Table returned information, we don't have a perfect match, time to relink\n            Set db = CurrentDb\n            Set rs = db.OpenRecordset("rtblODBC", dbOpenSnapshot)\n\n                'For each table definition in the database collection of tables\n                For Each tdf In db.TableDefs\n\n                    'Set strConnect variable to table connection string\n                    strConnect = tdf.Connect\n\n                    If Len(strConnect) > 0 And Left(tdf.Name, 1) <> "~" Then\n\n                        If Left(strConnect, 4) = "ODBC" Then\n\n                            'If there is a connection string, and it's not a temp table, and it IS an odbc table\n                            'Delete the table\n                            DoCmd.DeleteObject acTable, tdf.Name\n\n                        End If\n\n                    End If\n\n                Next\n\n                'Relink tables from rtblODBC\n                With rs\n\n                    .MoveFirst\n\n                    Do While Not .EOF\n\n                        Set tdf = db.CreateTableDef(!localtablename, dbAttachSavePWD, !SourceTableName, !ConnectString)\n\n                        varRet = SysCmd(acSysCmdSetStatus, "Relinking '" & !SourceTableName & "'")\n\n                        db.TableDefs.Append tdf\n                        db.TableDefs.Refresh\n\n                        If Len(!PrimaryKeyName & "") > 0 And Len(!PrimaryKeyField & "") > 0 Then\n\n                            sPrimaryKeyName = !PrimaryKeyName\n                            sPrimaryKeyField = !PrimaryKeyField\n                            sLocalTableName = !localtablename\n\n                            db.Execute "CREATE INDEX " & sPrimaryKeyName & " ON " & sLocalTableName & "(" & sPrimaryKeyField & ")WITH PRIMARY;"\n\n                        End If\n\n                        db.TableDefs.Refresh\n\n                        .MoveNext\n\n                    Loop\n\n                End With\n\n            subTurnOffSubDataSheets\n\n            fnReconnectODBC = True\n\n        End If\n\n    rst.Close\n    Set rst = Nothing\n\n    con.Close\n    Set con = Nothing\n\n\nExit_fnReconnectODBC:\n\n    Set tdf = Nothing\n    Set rs = Nothing\n    Set db = Nothing\n\n    varRet = SysCmd(acSysCmdClearStatus)\n\n    Exit Function\n\nErr_fnReconnectODBC:\n\n    fnReconnectODBC = False\n\n    sPrompt = "Press OK to continue."\n    vbMsg = MsgBox(sPrompt, vbOKOnly, "Error Reconnecting")\n    If vbMsg = vbOK Then\n\n        Resume Exit_fnReconnectODBC\n\n    End If\n\nEnd Functio