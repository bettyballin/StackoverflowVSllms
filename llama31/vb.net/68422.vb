Function MyFunction() As Boolean\n    ' some code here\n    Exit Function ' this will not return False\nEnd Function\n\nFunction MyFunction() As Boolean\n    ' some code here\n    Return False ' this will return False\nEnd Functio