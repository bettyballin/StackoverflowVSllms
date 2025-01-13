Public Class Form2\n    ' Declare the event\n    Public Event DataSaved As EventHandler\n\n    Private Sub btnSave_Click(sender As Object, e As EventArgs) Handles btnSave.Click\n        ' Call your Data Access Layer to update the database\n        UpdateDatabase()\n\n        ' Raise the DataSaved event\n        RaiseEvent DataSaved(Me, EventArgs.Empty)\n    End Sub\n\n    Private Sub UpdateDatabase()\n        ' Your code to update the database\n    End Sub\nEnd Class