Imports Microsoft.Win32\n\nPublic Module SqlCeChecker\n    Public Function GetInstalledSqlCeVersions() As List(Of String)\n        Dim versions As New List(Of String)()\n        Const keyPathBase As String = "SOFTWARE\Microsoft\Microsoft SQL Server Compact Edition"\n\n        Using baseKey As RegistryKey = Registry.LocalMachine.OpenSubKey(keyPathBase, False)\n            If baseKey IsNot Nothing Then\n                For Each subKeyName In baseKey.GetSubKeyNames()\n                    Dim versionKey As RegistryKey = baseKey.OpenSubKey(subKeyName, False)\n                    If versionKey IsNot Nothing AndAlso Not String.IsNullOrEmpty(versionKey.GetValue("Version")?.ToString()) Then\n                        versions.Add($"{subKeyName} - {versionKey.GetValue("Version").ToString()}")\n                        versionKey.Close()\n                    End If\n                Next\n            End If\n        End Using\n\n        Return versions\n    End Function\nEnd Module