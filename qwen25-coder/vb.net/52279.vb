Dim numbers(100) As Double\nDim random As New Random(0)\nFor i As Integer = 0 To numbers.Length - 1\n    numbers(i) = random.NextDouble()\nNext\n\n' Convert the array of Double to an array of IComparable\nDim comparableNumbers(numbers.Length - 1) As IComparable\nFor i As Integer = 0 To numbers.Length - 1\n    comparableNumbers(i) = DirectCast(numbers(i), IComparable)\nNext\n\nQuickSort.Sort(comparableNumbers)