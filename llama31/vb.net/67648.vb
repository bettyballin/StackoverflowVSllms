Private Sub m_oTestBtn_Click(ByVal Ctrl As Microsoft.Office.Core.CommandBarButton, ByRef CancelDefault As Boolean) Handles m_oTestBtn.Click\n    Dim AccessDB As dao.Database\n\n    On Error GoTo ErrHandler\n\n    AccessDB = AccessApplication.CurrentDb\n\n    MsgBox("DB Found " & AccessDB.Name)\n\n    'Try To Close Everything\n    AccessDB.Close()\n    System.Runtime.InteropServices.Marshal.ReleaseCOMObject(AccessDB)\n    AccessDB = Nothing\n\n    Exit Sub\n\nErrHandler:\n    MsgBox("Click Error")\n    AccessDB = Nothing\nEnd Sub