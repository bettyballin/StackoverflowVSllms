Private Shared _instance As PollsProvider = Nothing\n\n   Public Shared ReadOnly Property Instance() As PollsProvider\n       Get\n           If IsNothing(_instance) Then\n               _instance = New PollsProvider\n           End If\n           Return _instance\n       End Get\n   End Property