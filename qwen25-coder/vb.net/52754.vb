Public Property PropertyName As String\n    Get\n        Return _propertyName\n    End Get\n    Private Set(ByVal value As String)\n        _propertyName = value\n    End Set\nEnd Property\n\nPrivate _propertyName As String