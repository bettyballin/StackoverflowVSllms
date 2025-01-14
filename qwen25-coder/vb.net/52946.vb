Imports System.Diagnostics\nImports System.Runtime.InteropServices\nImports System.Threading\n\nPublic Class SingleInstanceChecker\n    Implements IDisposable\n\n    Private Shared mutex As Mutex\n    Private mainWindowHandle As IntPtr\n\n    Public ReadOnly Property IsAnotherInstanceRunning As Boolean\n        Get\n            Return Not mutex.WaitOne(0, False)\n        End Get\n    End Property\n\n    <DllImport("user32.dll")>\n    Private Shared Function ShowWindowAsync(ByVal hWnd As IntPtr, ByVal nCmdShow As Integer) As Boolean\n    End Function\n    \n    <DllImport("user32.dll")>\n    Private Shared Function SetForegroundWindow(ByVal hWnd As IntPtr) As Boolean\n    End Function\n\n    Private Const SW_RESTORE As Integer = 9\n\n    Public Sub New(mutexName As String, mainWindowHandle As IntPtr)\n        Me.mainWindowHandle = mainWindowHandle\n        mutex = New Mutex(True, mutexName)\n    End Sub\n\n    Public Sub BringToFront()\n        ShowWindowAsync(mainWindowHandle, SW_RESTORE)\n        SetForegroundWindow(mainWindowHandle)\n    End Sub\n\n    Public Sub Dispose() Implements IDisposable.Dispose\n        If Not IsNothing(mutex) Then\n            mutex.ReleaseMutex()\n            mutex.Dispose()\n        End If\n    End Sub\nEnd Class\n\nModule Program\n    Sub Main(args As String())\n        Dim mutexName As String = "YourUniqueAppName"\n        Dim singleInstanceChecker As New SingleInstanceChecker(mutexName, Process.GetCurrentProcess().MainWindowHandle)\n\n        If singleInstanceChecker.IsAnotherInstanceRunning Then\n            Console.WriteLine("An instance is already running.")\n            singleInstanceChecker.BringToFront()\n            Environment.Exit(0)\n        Else\n            ' Continue with your application logic...\n        End If\n    End Sub\nEnd Module