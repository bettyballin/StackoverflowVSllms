Dim RetVal as RetType\n\nTry\n    ...\n    If ... Then\n        RetVal = RetType.FailedParse\n    End If\n    ...\nFinally\n    Select Case RetVal\n        Case ...\n            UserStr = ...\n    End Select\nEnd Try\n\nReturn RetVal