' Using default parameters\nFunction SendMessage(message As String, recipient As String, cc As String = "")\n    ' Send message to recipient and optionally cc someone else\nEnd Function\n\n' Using function overloading\nOverloads Function SendMessage(message As String, recipient As String)\n    ' Send message to only the recipient\nEnd Function\n\nOverloads Function SendMessage(message As String, recipient As String, cc As String)\n    ' Send message to recipient and cc someone else\nEnd Functio