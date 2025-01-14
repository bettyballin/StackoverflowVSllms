Imports System.Runtime.InteropServices\nImports System.Security.Principal\nImports System.Data.SqlClient\n\nPublic Class ImpersonationHelper\n    <DllImport("advapi32.dll", SetLastError:=True, CharSet:=CharSet.Auto)>\n    Private Shared Function LogonUser(ByVal lpszUsername As String, ByVal lpszDomain As String, ByVal lpszPassword As String, ByVal dwLogonType As Integer, ByVal dwLogonProvider As Integer, ByRef phToken As IntPtr) As Boolean\n    End Function\n\n    <DllImport("advapi32.dll", CharSet:=CharSet.Auto, SetLastError:=True)>\n    Private Shared Function DuplicateToken(ByVal ExistingTokenHandle As IntPtr, ByVal ImpersonationLevel As Integer, ByRef DuplicateTokenHandle As IntPtr) As Boolean\n    End Function\n\n    <DllImport("advapi32.dll", CharSet:=CharSet.Auto, SetLastError:=True)>\n    Private Shared Function ImpersonateLoggedOnUser(ByVal hToken As IntPtr) As Boolean\n    End Function\n\n    <DllImport("kernel32.dll", CharSet:=CharSet.Auto)>\n    Private Shared Function CloseHandle(ByVal handle As IntPtr) As Boolean\n    End Function\n\n    Private Const LOGON32_LOGON_INTERACTIVE As Integer = 2\n    Private Const LOGON32_LOGON_NETWORK As Integer = 3\n    Private Const LOGON32_PROVIDER_DEFAULT As Integer = 0\n    Private Const SecurityImpersonation As Integer = 2\n\n    Public Shared Function Login(ByVal uid As String, ByVal pwd As String) As Boolean\n        Dim domainName As String = My.User.Name.Substring(0, My.User.Name.IndexOf("\"))\n        Dim token As IntPtr = IntPtr.Zero\n        Dim duplicateToken As IntPtr = IntPtr.Zero\n\n        If LogonUser(uid, domainName, pwd, LOGON32_LOGON_NETWORK, LOGON32_PROVIDER_DEFAULT, token) Then\n            If DuplicateToken(token, SecurityImpersonation, duplicateToken) Then\n                Using wi As WindowsIdentity = New WindowsIdentity(duplicateToken)\n                    Using context = wi.Impersonate()\n                        ' Set the current principal to the impersonated user\n                        My.User.CurrentPrincipal = New WindowsPrincipal(wi)\n                        ' Call your SQL Server logic here\n                        ' Example: Call a method to run SQL commands\n                        RunSqlCommands()\n                    End Using\n                End Using\n                CloseHandle(duplicateToken)\n            End If\n            CloseHandle(token)\n            Return True\n        Else\n            Return False\n        End If\n    End Function\n\n    Private Shared Sub RunSqlCommands()\n        Dim connectionString As String = "Server=myServerAddress;Database=myDataBase;Integrated Security=SSPI;"\n        Using conn As New SqlConnection(connectionString)\n            conn.Open()\n            ' Execute your SQL commands here\n        End Using\n    End Sub\nEnd Class