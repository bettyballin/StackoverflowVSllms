Function IsInteger(value As String) As Boolean\n    Dim result As Integer\n    Return Integer.TryParse(value, result)\nEnd Functio