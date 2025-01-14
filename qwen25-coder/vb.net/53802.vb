Imports System.Configuration\n\nPublic Function GetConnectionString(ByVal Setting As String) As String\n    If Setting = "Demo" Then\n        Return ConfigurationManager.AppSettings("DemoConnectionString")\n    ElseIf Setting = "Live" Then\n        Return ConfigurationManager.AppSettings("LiveConnectionString")\n    Else\n        Throw New ArgumentException("Invalid setting specified.")\n    End If\nEnd Functio