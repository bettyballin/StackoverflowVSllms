Public Class Form1\n\n    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load\n        TestRoutine(Y:="TestString", X:=12)\n    End Sub\n\n    Private Sub TestRoutine(ByVal X As Long, Optional Y As String = "")\n        ' Do something with X and Y here... '\n    End Sub\n\nEnd Class