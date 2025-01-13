Private errorDictionary As New Dictionary(Of String, ErrorCode) From {\n    {"Failed because I don't know about it", ErrorCode.Unknown},\n    '...\n}\n\nIf errorDictionary.TryGetValue(returnedString, errorCode) Then\n    Select Case errorCode\n        Case ErrorCode.Unknown\n            'do something'\n        '...\n    End Select\nEnd If\n\nEnum ErrorCode\n    Unknown\n    '...\nEnd Enum