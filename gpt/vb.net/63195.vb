Public Class MainForm\n    Private dbHandler As New DatabaseHandler()\n\n    Private Sub MainForm_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n        ' Add a new user\n        dbHandler.AddUser("John Doe")\n\n        ' Get and display all users\n        Dim users As List(Of String) = dbHandler.GetUsers()\n        For Each user As String In users\n            MessageBox.Show(user)\n        Next\n    End Sub\nEnd Class