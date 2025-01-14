Imports System.Windows.Forms\n\nPublic Class Form1\n\n    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n        ' Show the NotifyIcon but hide the main form\n        NotifyIcon1.Visible = True\n        Me.Hide()\n    End Sub\n\n    Private Sub Form1_FormClosing(sender As Object, e As FormClosingEventArgs) Handles MyBase.FormClosing\n        ' Prevents the application from exiting when the form closes\n        If e.CloseReason = CloseReason.UserClosing Then\n            e.Cancel = True\n            Me.Hide() ' Hide the form again if it's already hidden\n        End If\n    End Sub\n\nEnd Class