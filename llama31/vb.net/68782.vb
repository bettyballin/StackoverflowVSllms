Public Class LoginForm\n    Public Property LoginDetails As LoginBean\n\n    Private Sub btnLogin_Click(sender As Object, e As EventArgs) Handles btnLogin.Click\n        ' Validate user input...\n        LoginDetails = New LoginBean(txtUsername.Text, txtPassword.Text)\n        Me.DialogResult = DialogResult.OK\n    End Sub\nEnd Class\n\nPublic Class Form1\n    Private Sub btnLogin_Click(sender As Object, e As EventArgs) Handles btnLogin.Click\n        Dim loginForm As New LoginForm()\n        If loginForm.ShowDialog() = DialogResult.OK Then\n            Dim loginDetails As LoginBean = loginForm.LoginDetails\n            ' Use the login details...\n        End If\n    End Sub\nEnd Class\n\nPublic Class LoginBean\n    Public Property Username As String\n    Public Property Password As String\n\n    Public Sub New(username As String, password As String)\n        Me.Username = username\n        Me.Password = password\n    End Sub\nEnd Class