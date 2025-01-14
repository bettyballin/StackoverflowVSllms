Dim calculationText As String = "Your text here... can be multiline with spaces between numbers"\nDim lines() As String = calculationText.Split(vbCrLf)\nDim resultList As New List(Of Double)()\n\nFor Each line In lines\n    ' Split each line by space to keep all values including those separated by spaces.\n    Dim values() As String = line.Split(" "c, StringSplitOptions.RemoveEmptyEntries)\n    \n    For i As Integer = 0 To values.Length - 1\n        ' Convert each value to a double and add to the result list.\n        resultList.Add(Convert.ToDouble(values(i)))\n    Next\nNext\n\n' Now resultList contains all numbers in the order they appear in the text.\nDim resultArray() As Double = resultList.ToArray()\n\n' For demonstration: print out the array\nFor Each num As Double In resultArray\n    Console.WriteLine(num)\nNext