Public Class PDFExporter\n    Public Delegate Function FileExistsDelegate(filePath As String) As Boolean\n\n    Private _fileExistsHandler As FileExistsDelegate\n\n    Public Sub SetFileExistsHandler(handler As FileExistsDelegate)\n        _fileExistsHandler = handler\n    End Sub\n\n    Private Sub CheckAndProcessFile(filePath As String)\n        If IO.File.Exists(filePath) AndAlso Not (_fileExistsHandler?.Invoke(filePath) OrElse False) Then\n            Exit Sub\n        End If\n\n        ' Logic to export PDF here...\n    End Sub\nEnd Class