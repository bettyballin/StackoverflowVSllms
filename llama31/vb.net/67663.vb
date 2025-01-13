Private Shared Function GetINPUTFromKeyCode(ByVal keyCode As Short, ByVal isDown As Boolean) As INPUT\n    Dim input As New INPUT()\n    input.dwType = INPUT_KEYBOARD\n    input.mkhi.ki.wVk = keyCode\n    If isDown = False Then\n        input.mkhi.ki.dwFlags = KEYEVENTF_KEYUP\n    Else\n        input.mkhi.ki.dwFlags = 0\n    End If\n    Return input\nEnd Functio