Public Class Example\n    Private _foo As Foo\n\n    Public Property Foo() As Foo\n        Get\n            Return _foo\n        End Get\n        Private Set(value As Foo)\n            _foo = value\n        End Set\n    End Property\nEnd Class