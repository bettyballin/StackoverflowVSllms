Public Class LoadingForm\n    ' This form displays a loading message\n    Private Sub LoadingForm_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n        Me.Label1.Text = "Loading..."\n    End Sub\nEnd Class