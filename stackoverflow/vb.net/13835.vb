Public Class objLocation\n  ...\nDefault Public ReadOnly Property Indexer(ByVal index As Integer)\n    Get\n        Select Case index\n            Case 0\n                Return SysLocationId\n            Case 1\n                Return NameFull\n            Case 2\n                Return LatRaw\n            Case 3\n                Return LongRaw\n            Case 4\n                Return Active\n            Case Else\n                Throw New ArgumentException\n        End Select\n    End Get\n  End Property