Function ParseId(id As String, varName As String) As String\n    ' Use id and varName as needed\n    Console.WriteLine($"The value of {varName} is {id}")\n    Return id\nEnd Function\n\n' Usage\nDim myId As String = "12345"\nParseId(myId, NameOf(myId))