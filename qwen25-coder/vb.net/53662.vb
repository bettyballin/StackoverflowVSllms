' In Form1.vb\n\nPrivate Sub btnOpenLoginForm_Click(sender As Object, e As EventArgs) Handles btnOpenLoginForm.Click\n    Using loginForm As New LoginForm()\n        Dim result = loginForm.ShowDialog()\n\n        If result = DialogResult.OK Then\n            ' Use the username and password from the LoginForm.\n            Dim enteredUsername = loginForm.Username\n            Dim enteredPassword = loginForm.Password\n            \n            ' Perform actions with the retrieved credentials here.\n        End If\n    End Using\nEnd Sub