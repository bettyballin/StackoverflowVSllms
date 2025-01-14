' Convert listOfStrings to HashSet for faster lookup\nDim hashSetOfStrings As New HashSet(Of String)(listOfStrings)\n\n' Check if myString contains any element from hashSetOfStrings\nIf hashSetOfStrings.Any(Function(s) myString.Contains(s)) Then\n    Return True\nEnd If\n\nReturn False