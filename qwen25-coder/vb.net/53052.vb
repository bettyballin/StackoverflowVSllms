Dim num As Integer\n  Try\n      num = Integer.Parse("123")\n  Catch ex As FormatException\n      ' Handle the case when the string is not a valid integer\n  End Try