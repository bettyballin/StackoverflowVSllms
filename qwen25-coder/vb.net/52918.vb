Private Shared ReadOnly _helper As New Lazy(Of MyHelperClass)(Function() New MyHelperClass())\n\nPublic Shared ReadOnly Property Helper() As MyHelperClass\n    Get\n        Return _helper.Value\n    End Get\nEnd Property