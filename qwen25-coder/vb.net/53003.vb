Class Deck\n    Public cards(51) As Card\n\n    Sub New()\n        ' Initialize each card in the deck\n        For i As Integer = 0 To 51\n            cards(i) = New Card()\n        Next\n    End Sub\nEnd Class