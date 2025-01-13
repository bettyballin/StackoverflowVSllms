Imports System.Runtime.InteropServices\n\nModule Module1\n\n    <DllImport("Wtsapi32.dll", SetLastError:=True)>\n    Private Function WTSQuerySessionInformation(\n        ByVal hServer As IntPtr,\n        ByVal sessionId As Integer,\n        ByVal infoClass As WTS_INFO_CLASS,\n        ByRef ppBuffer As IntPtr,\n        ByRef pBytesReturned As Integer) As Boolean\n    End Function\n\n    <DllImport("Wtsapi32.dll")>\n    Private Sub WTSFreeMemory(ByVal pMemory As IntPtr)\n    End Sub\n\n    Private Enum WTS_INFO_CLASS\n        WTSClientName = 10\n    End Enum\n\n    Private Const WTS_CURRENT_SERVER_HANDLE As IntPtr = IntPtr.Zero\n    Private Const WTS_CURRENT_SESSION As Integer = -1\n\n    Sub Main()\n        Try\n            Dim clientName As String = GetClientName()\n            Console.WriteLine("Client Name: " & clientName)\n        Catch ex As Exception\n            Console.WriteLine("Error: " & ex.Message)\n        End Try\n    End Sub\n\n    Function GetClientName() As String\n        Dim buffer As IntPtr = IntPtr.Zero\n        Dim bytesReturned As Integer = 0\n\n        If WTSQuerySessionInformation(WTS_CURRENT_SERVER_HANDLE, WTS_CURRENT_SESSION, WTS_INFO_CLASS.WTSClientName, buffer, bytesReturned) Then\n            If bytesReturned > 1 Then\n                Dim clientName As String = Marshal.PtrToStringAnsi(buffer)\n                WTSFreeMemory(buffer)\n                Return clientName\n            End If\n            WTSFreeMemory(buffer)\n        End If\n\n        Throw New ApplicationException("Unable to retrieve client name.")\n    End Function\n\nEnd Module