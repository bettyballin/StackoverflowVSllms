Dim detector As New ThemeDetector()\nDim theme As String = detector.GetCurrentWindowsTheme()\n\nIf theme = "Classic" Then\n    ' Adjust your form for classic style.\nElseIf theme Contains "luna.msstyles" Then\n    ' Do nothing as it's already good for XP style.\nElse\n    ' Handle other themes if necessary.\nEnd If