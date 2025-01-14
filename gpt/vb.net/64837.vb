Imports System.Reflection\nImports System.IO\n\nPublic Class CrystalReportsChecker\n    Public Shared Function IsCrystalReportsInstalled() As Boolean\n        Try\n            ' Attempt to load the CrystalDecisions.CrystalReports.Engine assembly\n            Dim assemblyName As String = "CrystalDecisions.CrystalReports.Engine, Version=13.0.2000.0, Culture=neutral, PublicKeyToken=692fbea5521e1304"\n            Dim assembly As Assembly = Assembly.Load(assemblyName)\n            Return True\n        Catch ex As FileNotFoundException\n            ' The assembly is not found\n            Return False\n        Catch ex As Exception\n            ' Other exceptions\n            Return False\n        End Try\n    End Function\nEnd Class