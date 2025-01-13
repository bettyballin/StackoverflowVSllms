Imports System.Runtime.InteropServices\n\nPublic Class Form1\n\n    <DllImport("user32.dll", CharSet:=CharSet.Auto, SetLastError:=True)>\n    Private Shared Function SetWindowsHookEx(\n        ByVal idHook As Integer,\n        ByVal lpfn As LowLevelHookProc,\n        ByVal hMod As IntPtr,\n        ByVal dwThreadId As UInteger\n    ) As IntPtr\n    End Function\n\n    <DllImport("user32.dll", CharSet:=CharSet.Auto, SetLastError:=True)>\n    Private Shared Function UnhookWindowsHookEx(ByVal hhk As IntPtr) As Boolean\n    End Function\n\n    <DllImport("user32.dll", CharSet:=CharSet.Auto, SetLastError:=True)>\n    Private Shared Function CallNextHookEx(\n        ByVal hhk As IntPtr,\n        ByVal nCode As Integer,\n        ByVal wParam As IntPtr,\n        ByVal lParam As IntPtr\n    ) As IntPtr\n    End Function\n\n    Private Delegate Function LowLevelHookProc(\n        ByVal nCode As Integer,\n        ByVal wParam As IntPtr,\n        ByVal lParam As IntPtr\n    ) As IntPtr\n\n    Const WH_MOUSE_LL As Integer = 14\n    Const WH_KEYBOARD_LL As Integer = 13\n\n    Private mouseHook As IntPtr\n    Private keyboardHook As IntPtr\n    Private lastActivity As DateTime\n    Private IsRunning As Boolean = False\n\n    Private Sub HookMouse()\n        mouseHook = SetWindowsHookEx(WH_MOUSE_LL, AddressOf MouseHookProc, IntPtr.Zero, 0)\n    End Sub\n\n    Private Sub HookKeyboard()\n        keyboardHook = SetWindowsHookEx(WH_KEYBOARD_LL, AddressOf KeyboardHookProc, IntPtr.Zero, 0)\n    End Sub\n\n    Private Sub UnhookMouse()\n        UnhookWindowsHookEx(mouseHook)\n    End Sub\n\n    Private Sub UnhookKeyboard()\n        UnhookWindowsHookEx(keyboardHook)\n    End Sub\n\n    Private Function MouseHookProc(\n        ByVal nCode As Integer,\n        ByVal wParam As IntPtr,\n        ByVal lParam As IntPtr\n    ) As IntPtr\n        If nCode >= 0 AndAlso (wParam.ToInt64() = &H200 OrElse wParam.ToInt64() = &H201 OrElse wParam.ToInt64() = &H204 OrElse wParam.ToInt64() = &H207) Then\n            lastActivity = DateTime.Now\n        End If\n        Return CallNextHookEx(mouseHook, nCode, wParam, lParam)\n    End Function\n\n    Private Function KeyboardHookProc(\n        ByVal nCode As Integer,\n        ByVal wParam As IntPtr,\n        ByVal lParam As IntPtr\n    ) As IntPtr\n        If nCode >= 0 AndAlso (wParam.ToInt64() = &H100 OrElse wParam.ToInt64() = &H104) Then\n            lastActivity = DateTime.Now\n        End If\n        Return CallNextHookEx(keyboardHook, nCode, wParam, lParam)\n    End Function\n\n    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n        HookMouse()\n        HookKeyboard()\n        IsRunning = True\n        lastActivity = DateTime.Now\n        Timer1.Interval = 1000 ' Check every second\n        Timer1.Start()\n    End Sub\n\n    Private Sub Form1_FormClosing(sender As Object, e As FormClosingEventArgs) Handles MyBase.FormClosing\n        UnhookMouse()\n        UnhookKeyboard()\n        IsRunning = False\n    End Sub\n\n    Private Sub Timer1_Tick(sender As Object, e As EventArgs) Handles Timer1.Tick\n        If IsRunning Then\n            Dim elapsed As TimeSpan = DateTime.Now - lastActivity\n            If elapsed.TotalMinutes > 5 Then ' Example: 5 minutes of inactivity\n                ' You can log or display the activity time here\n                ' For demonstration, let's display it in the form's title\n                Me.Text = "Last activity was at " & lastActivity.ToString()\n            Else\n                ' There has been activity, you can update your records or display here\n                Me.Text = "Computer is in use..."\n            End If\n        End If\n    End Sub\nEnd Class