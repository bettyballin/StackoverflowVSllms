Public Class ErrorClass\n    Public Shared ReadOnly UnknownString As String = "Failed because I don't know about it"\n    '...\nEnd Class\n\nIf returnedString = ErrorClass.UnknownString Then\n    'do something'\nEnd If