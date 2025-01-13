Public Function SaveFileAsBlob(fullFileName As String, documentDescription As String) As Boolean\n\n    'Upload a binary file into the database as a BLOB\n    'Based on this example: http://www.codeguru.com/forum/printthread.php?t=337027\n\n    Dim rstUpload As ADODB.Recordset\n    Dim pkValue AS Long\n    On Error GoTo ErrorHandler\n\n    Screen.MousePointer = vbHourglass        \n\n    'Create a new record (but leave document blank- we will update the doc in a moment)\n    'the where clause ensures *no* result set; we only want the structure\n    strSQL = "SELECT DOC_NUMBER, DOC_DESC, BLOB_FIELD " & _\n      " FROM MY_TABLE " & _\n      " WHERE PRIMARY_KEY = 0" \n    pkValue = GetNextPKValue\n\n    Set rstUpload = New ADODB.Recordset\n    With rstUpload\n      .CursorType = adOpenKeyset\n      .LockType = adLockOptimistic\n      .Open strSQL, myConn\n      .AddNew Array("DOC_NUMBER", "DOC_DESC"), _\n              Array(pkValue, documentDescription)\n      .Close\n    End With\n\n    'They may have the document open in an external application.  Create a copy and work with that copy\n    Dim tmpFileName As String\n    tmpFileName = GetTempPath & ExtractFileName(fullFileName)\n    'if the tmp file exists, delete it\n    If Len(Dir(tmpFileName)) > 0 Then\n      Kill tmpFileName\n    End If\n\n    'see this URL for info about this subroutine:\n    'http://stackoverflow.com/questions/848087/how-can-i-copy-an-open-file-using-vb6\n    CopyFileEvenIfOpen fullFileName, tmpFileName\n\n    'Now that our record is inserted, update it with the file from disk\n    Set rstUpload = Nothing\n    Set rstUpload = New ADODB.Recordset\n    Dim st As ADODB.Stream\n    rstUpload.Open "SELECT BLOB_FIELD FROM MY_TABLE WHERE PRIMARY_KEY = " & pkValue\n      , myConn, adOpenDynamic, adLockOptimistic\n    Set st = New ADODB.Stream\n    st.Type = adTypeBinary\n    st.Open\n    st.LoadFromFile (tmpFileName)\n    rstUpload.Fields("BLOB_FIELD").Value = st.Read\n    rstUpload.Update\n\n    'Now delete the temp file we created\n    Kill (tmpFileName)\n\n    DocAdd = True\nExitPoint:\n    On Error Resume Next\n    rstUpload.Close\n    st.Close\n    Set rstUpload = Nothing\n    Set st = Nothing\n    Screen.MousePointer = vbDefault\n    Exit Function\nErrorHandler:\n    DocAdd = False\n    Screen.MousePointer = vbDefault\n    MsgBox "Source: " & Err.Source & vbCrLf & "Number: " & Err.Number & vbCrLf & Err.Description, vbCritical, _\n         "DocAdd Error"\n    Resume ExitPoint\nEnd Functio