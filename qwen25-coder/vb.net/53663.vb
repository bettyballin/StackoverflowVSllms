' Declare and initialize a jagged array\nDim jaggedArray()() As Integer = {\n    {1, 2, 3},\n    {4, 5, 6, 7, 8, 9, 9, 9},\n    {5, 4, 3, 2}\n}\n\n' Iterate over the jagged array\nFor y As Integer = 0 To jaggedArray.Length - 1\n    For x As Integer = 0 To jaggedArray(y).Length - 1\n        ' Access elements\n        Dim value As Integer = jaggedArray(y)(x)\n        Console.WriteLine($"Element at [{y}][{x}] is {value}")\n    Next\nNext