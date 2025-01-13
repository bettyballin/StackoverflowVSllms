Imports Microsoft.Win32\n\nPublic Function IsSqlCeInstalled() As Boolean\n    Dim regKey As RegistryKey = Registry.LocalMachine.OpenSubKey("SOFTWARE\Microsoft\Microsoft SQL Server Compact Edition")\n    If regKey IsNot Nothing Then\n        Return True\n    Else\n        Return False\n    End If\nEnd Function\n\nPublic Function GetSqlCeVersion() As String\n    Dim regKey As RegistryKey = Registry.LocalMachine.OpenSubKey("SOFTWARE\Microsoft\Microsoft SQL Server Compact Edition")\n    If regKey IsNot Nothing Then\n        For Each subKey As String In regKey.GetSubKeyNames()\n            If subKey.StartsWith("v") Then\n                Dim versionKey As RegistryKey = regKey.OpenSubKey(subKey)\n                If versionKey IsNot Nothing Then\n                    Return versionKey.GetValue("Version").ToString()\n                End If\n            End If\n        Next\n    End If\n    Return String.Empty\nEnd Functio