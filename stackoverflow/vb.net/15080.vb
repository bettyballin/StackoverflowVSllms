Dim myProcessStartInfo As ProcessStartInfo = New ProcessStartInfo\n\n    With myProcessStartInfo\n\n        .FileName = "file path and name"\n\n        .Domain = "domainname"\n        .UserName = "username"\n\n        'password needs to be a SerureString\n        Using NewPassword As New Security.SecureString\n            With NewPassword\n                For Each c As Char In "password".ToCharArray\n                    .AppendChar(c)\n                Next c\n                .MakeReadOnly()\n            End With\n            .Password = NewPassword.Copy\n        End Using\n\n        'UseShellExecute must be false for impersonated process\n        .UseShellExecute = False\n\n    End With\n\n    Using Process As New System.Diagnostics.Process\n        With Process\n            .StartInfo = myProcessStartInfo\n            .Start()\n        End With\n    End Using