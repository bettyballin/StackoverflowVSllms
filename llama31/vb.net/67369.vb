Public Class frmTestApp\n    Private Sub btnRunServiceMethod_Click(sender As Object, e As EventArgs) Handles btnRunServiceMethod.Click\n        ServiceMethodLogger.InitializeLogger()\n        Dim logViewer As New frmLogViewer()\n        logViewer.Show()\n        MyServiceMethod.ImportData()\n    End Sub\nEnd Class