Imports System.Data.SQLite\n\nPublic Sub InsertDataIntoDatabase()\n    Dim dbPath As String = "C:\path\to\your\vault.db" ' Update this path\n    Using SQLconnect As New SQLiteConnection("Data Source=" & dbPath & ";Version=3;")\n        Try\n            SQLconnect.Open()\n\n            Dim SQLcommand As New SQLiteCommand_SQLite(SQLconnect)\n            SQLcommand.CommandText = "INSERT INTO entries (column1, column2, column3) VALUES (@appinput, @userinput, @passinput)"\n            \n            ' Use parameters to prevent SQL injection\n            SQLcommand.Parameters.AddWithValue("@appinput", appinput.Text)\n            SQLcommand.Parameters.AddWithValue("@userinput", userinput.Text)\n            SQLcommand.Parameters.AddWithValue("@passinput", passinput.Text)\n\n            SQLcommand.ExecuteNonQuery()\n        Catch ex As Exception\n            MessageBox.Show("An error occurred: " & ex.Message)\n        Finally\n            SQLconnect.Close()\n        End Try\n    End Using\n\n    Me.Hide()\nEnd Sub