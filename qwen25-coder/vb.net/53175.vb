Dim num As Integer = 5\nDim str As String = "The number is "\n\n' Using & operator\nConsole.WriteLine(str & num) ' Outputs: The number is 5\n\n' Using + operator\nConsole.WriteLine(str + num) ' Also outputs: The number is 5, but mixing with numbers can lead to errors if not careful