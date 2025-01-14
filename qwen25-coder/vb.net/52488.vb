Dim RetVal As RetType\n\nTry\n    ' Your code logic here...\n    If ... Then\n        RetVal = RetType.FailedParse\n    End If\n    \nCatch ex As Exception\n    ' Handle exceptions if necessary\nFinally\n    Select Case RetVal\n        Case RetType.Success\n            UserStr = "The operation was successful."\n        Case RetType.FailedParse\n            UserStr = "Failed to parse the input."\n        Case Else\n            UserStr = "An unexpected error occurred."\n    End Select\n    \n    ' Optionally handle other cleanup activities here.\nEnd Try\n\nReturn RetVal