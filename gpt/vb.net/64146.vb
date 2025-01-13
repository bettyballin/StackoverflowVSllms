Public MustInherit Class FooBase\n    Public Event StatusTextChanged(ByVal StatusText As String)\n    \n    Private _StatusText As String = "Idle."\n    Public Property StatusText() As String\n        Get\n            Return _StatusText\n        End Get\n        Protected Set(ByVal value As String)\n            If _StatusText <> value Then\n                _StatusText = value\n                RaiseEvent StatusTextChanged(value)\n            End If\n        End Set\n    End Property\nEnd Class