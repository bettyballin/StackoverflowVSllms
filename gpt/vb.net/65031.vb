Dim input As String = "I ALN 123456 1234567"\nDim regex As New Regex("I [A-Za-z0-9]{3} \d{6} \d{7}")\n\nIf regex.IsMatch(input) Then\n    Console.WriteLine("Pattern matched!")\nElse\n    Console.WriteLine("Pattern not matched.")\nEnd If