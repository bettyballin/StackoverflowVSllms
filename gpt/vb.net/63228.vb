Function IsInteger(value As String) As Boolean\n    Dim tempInt As Integer\n    Return Integer.TryParse(value, tempInt)\nEnd Functio