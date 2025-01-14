Public Class MyService\n    Inherits ServiceBase\n\n    Private webServer As SimpleWebServer\n\n    Protected Overrides Sub OnStart(ByVal args() As String)\n        webServer = New SimpleWebServer()\n        Task.Run(Sub() webServer.Start("http://localhost:1234/"))\n    End Sub\n\n    Protected Overrides Sub OnStop()\n        If webServer IsNot Nothing Then\n            webServer.Stop()\n        End If\n    End Sub\nEnd Class