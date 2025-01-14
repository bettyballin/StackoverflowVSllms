Imports System.Runtime.InteropServices\nImports System.Drawing\n\nPublic Class NativeMethods\n\n    Private Structure INPUT\n        Dim dwType As Integer\n        Dim mkhi As MOUSEKEYBDHARDWAREINPUT\n    End Structure\n\n    Private Structure KEYBDINPUT\n        Public wVk As UShort\n        Public wScan As UShort\n        Public dwFlags As UInteger\n        Public time As UInteger\n        Public dwExtraInfo As IntPtr\n    End Structure\n\n    Private Structure HARDWAREINPUT\n        Public uMsg As UInteger\n        Public wParamL As UShort\n        Public wParamH As UShort\n    End Structure\n\n    Private Structure MOUSEKEYBDHARDWAREINPUT\n        Public ki As KEYBDINPUT\n        Public mi As MOUSEINPUT\n        Public hi As HARDWAREINPUT\n    End Structure\n\n    Private Structure MOUSEINPUT\n        Public dx As Integer\n        Public dy As Integer\n        Public mouseData As UInteger\n        Public dwFlags As UInteger\n        Public time As UInteger\n        Public dwExtraInfo As IntPtr\n    End Structure\n\n    ' Constants for SendInput\n    Const INPUT_MOUSE As UInteger = 0\n    Public Const INPUT_KEYBOARD As Integer = 1\n    Const INPUT_HARDWARE As Integer = 2\n    Public Const KEYEVENTF_EXTENDEDKEY As UInteger = &H1\n    Public Const KEYEVENTF_KEYUP As UInteger = &H2\n    Public Const KEYEVENTF_UNICODE As UInteger = &H4\n    Public Const KEYEVENTF_SCANCODE As UInteger = &H8\n    Const XBUTTON1 As UInteger = &H1\n    Const XBUTTON2 As UInteger = &H2\n    Const MOUSEEVENTF_MOVE As UInteger = &H1\n    Const MOUSEEVENTF_LEFTDOWN As UInteger = &H2\n    Const MOUSEEVENTF_LEFTUP As UInteger = &H4\n    Const MOUSEEVENTF_RIGHTDOWN As UInteger = &H8\n    Const MOUSEEVENTF_RIGHTUP As UInteger = &H10\n\n    <DllImport("user32.dll", SetLastError:=True)>\n    Private Shared Function SendInput(nInputs As UInteger, pInputs() As INPUT, cbSize As Integer) As UInteger\n    End Function\n\n    Public Shared Sub SendEnterKey()\n        Dim inputs(1) As INPUT\n\n        ' Key down\n        inputs(0).dwType = INPUT_KEYBOARD\n        inputs(0).mkhi.ki.wVk = &HD ' VK_RETURN\n        inputs(0).mkhi.ki.dwFlags = 0\n        inputs(0).mkhi.ki.time = 0\n        inputs(0).mkhi.ki.dwExtraInfo = IntPtr.Zero\n\n        ' Key up\n        inputs(1).dwType = INPUT_KEYBOARD\n        inputs(1).mkhi.ki.wVk = &HD ' VK_RETURN\n        inputs(1).mkhi.ki.dwFlags = KEYEVENTF_KEYUP\n        inputs(1).mkhi.ki.time = 0\n        inputs(1).mkhi.ki.dwExtraInfo = IntPtr.Zero\n\n        ' Send the input\n        SendInput(CType(inputs.Length, UInteger), inputs, Marshal.SizeOf(GetType(INPUT)))\n    End Sub\n\nEnd Class