Public Class PersonRecord\n\n    Private _myPerson As Person\n\n    Public Property MyPerson As Person\n        Get\n            If _myPerson Is Nothing Then\n                _myPerson = Person.GetAppropriatePerson(Me.PersonID)\n            End If\n            Return _myPerson\n        End Get\n        Set\n            _myPerson = value\n        End Set\n    End Property\n\nEnd Class