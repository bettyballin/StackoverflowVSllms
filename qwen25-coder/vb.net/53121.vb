Function FindWord(board As 2D Array, word As String) As Boolean\n    Dim rows = board.GetLength(0)\n    Dim cols = board.GetLength(1)\n\n    ' Directions array to navigate through adjacent cells (8 possible directions)\n    Dim directions As List(Of Tuple(Of Integer, Integer)) = {\n        Tuple.Create(-1, -1), Tuple.Create(-1, 0), Tuple.Create(-1, 1),\n        Tuple.Create(0, -1),                 Tuple.Create(0, 1),\n        Tuple.Create(1, -1), Tuple.Create(1, 0), Tuple.Create(1, 1)\n    }\n\n    ' Helper function to perform DFS\n    Function DFS(x As Integer, y As Integer, index As Integer) As Boolean\n        ' If all characters are matched\n        If index = word.Length Then\n            Return True\n        End If\n\n        ' Check boundaries and if the current cell is not used in this path\n        If x < 0 OrElse y < 0 OrElse x >= rows OrElse y >= cols OrElse board(x, y) <> word(index) Then\n            Return False\n        End If\n\n        ' Mark the cell as visited for the current path\n        Dim temp = board(x, y)\n        board(x, y) = "$" ' or any marker character other than a letter on Boggle dice\n\n        ' Explore all 8 adjacent cells\n        For Each dir In directions\n            Dim newX = x + dir.Item1\n            Dim newY = y + dir.Item2\n            If DFS(newX, newY, index + 1) Then\n                board(x, y) = temp ' Unmark the cell for other paths\n                Return True\n            End If\n        Next\n\n        ' Unmark the cell as it doesn't lead to a solution\n        board(x, y) = temp\n        Return False\n    End Function\n\n    ' Try to find the word starting from each cell on the board\n    For i As Integer = 0 To rows - 1\n        For j As Integer = 0 To cols - 1\n            If DFS(i, j, 0) Then\n                Return True\n            End If\n        Next\n    Next\n\n    ' Word not found\n    Return False\nEnd Functio