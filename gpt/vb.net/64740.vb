Private Sub SubmitButton_Click()\n    ' Declare variables\n    Dim db As DAO.Database\n    Dim rs As DAO.Recordset\n\n    ' Set the database\n    Set db = CurrentDb\n\n    ' Open the recordset\n    Set rs = db.OpenRecordset("YourTableName", dbOpenDynaset)\n\n    ' Add a new record\n    rs.AddNew\n    \n    ' Set the values from the textboxes\n    rs!FieldName1 = Me.TextBox1.Value\n    rs!FieldName2 = Me.TextBox2.Value\n    ' Add more fields as needed\n\n    ' Update the recordset to save the new record\n    rs.Update\n\n    ' Close the recordset\n    rs.Close\n    Set rs = Nothing\n    Set db = Nothing\n\n    ' Optionally, refresh the form or notify the user\n    Me.Requery\n    MsgBox "Record added successfully!"\nEnd Sub