Public Class DataContextProvider\n    Private _dc As MyDataContext\n\n    Public Sub New()\n        _dc = New MyDataContext()\n    End Sub\n\n    Public ReadOnly Property DataContext() As MyDataContext\n        Get\n            Return _dc\n        End Get\n    End Property\nEnd Class\n\nPartial Public Class User\n    Private _dataProvider As DataContextProvider\n\n    Public Sub New(dataProvider As DataContextProvider)\n        _dataProvider = dataProvider\n    End Sub\n\n    Public Function GetUser(ByVal UserID As Integer) As User\n        Return (From u In _dataProvider.DataContext.Users Where u.ID = UserID).Single()\n    End Function\n\n    ' other methods...\nEnd Class