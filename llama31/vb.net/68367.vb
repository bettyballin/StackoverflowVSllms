Dim ResultString As String\nTry\n    Dim RegexObj As New Regex("[^\d]")\n    ResultString = RegexObj.Replace(SubjectString, "")\nCatch ex As ArgumentException\n    'Syntax error in the regular expression\nEnd Try