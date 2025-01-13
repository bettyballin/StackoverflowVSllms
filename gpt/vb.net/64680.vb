Imports System\nImports System.Runtime.InteropServices\n\nPublic Class ProcessLauncher\n\n    <StructLayout(LayoutKind.Sequential)>\n    Public Structure STARTUPINFO\n        Public cb As Integer\n        Public lpReserved As String\n        Public lpDesktop As String\n        Public lpTitle As String\n        Public dwX As Integer\n        Public dwY As Integer\n        Public dwXSize As Integer\n        Public dwYSize As Integer\n        Public dwXCountChars As Integer\n        Public dwYCountChars As Integer\n        Public dwFillAttribute As Integer\n        Public dwFlags As Integer\n        Public wShowWindow As Short\n        Public cbReserved2 As Short\n        Public lpReserved2 As IntPtr\n        Public hStdInput As IntPtr\n        Public hStdOutput As IntPtr\n        Public hStdError As IntPtr\n    End Structure\n\n    <StructLayout(LayoutKind.Sequential)>\n    Public Structure PROCESS_INFORMATION\n        Public hProcess As IntPtr\n        Public hThread As IntPtr\n        Public dwProcessId As Integer\n        Public dwThreadId As Integer\n    End Structure\n\n    <DllImport("advapi32.dll", SetLastError:=True, CharSet:=CharSet.Unicode)>\n    Public Shared Function CreateProcessWithLogonW(\n        ByVal lpUsername As String,\n        ByVal lpDomain As String,\n        ByVal lpPassword As String,\n        ByVal dwLogonFlags As UInteger,\n        ByVal lpApplicationName As String,\n        ByVal lpCommandLine As String,\n        ByVal dwCreationFlags As UInteger,\n        ByVal lpEnvironment As IntPtr,\n        ByVal lpCurrentDirectory As String,\n        ByRef lpStartupInfo As STARTUPINFO,\n        ByRef lpProcessInformation As PROCESS_INFORMATION) As Boolean\n    End Function\n\n    Public Const LOGON_WITH_PROFILE As UInteger = &H1\n    Public Const LOGON_NETCREDENTIALS_ONLY As UInteger = &H2\n    Public Const CREATE_NO_WINDOW As UInteger = &H8000000\n\nEnd Class