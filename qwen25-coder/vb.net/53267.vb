Dim userInput As String = "LU Engineering"\nDim selectExpression As String = BuildSelectExpression(userInput)\nDim rows() As DataRow = dataTable.Select(selectExpression)\n\nFor Each row In rows\n    ' Process each row here...\nNext