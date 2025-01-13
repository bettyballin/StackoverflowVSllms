Public Class MyClass\n    Implements IMyClass\n\n    Public Property IsDirty() As Boolean\n        Get\n            Return _isDirty\n        End Get\n        Friend Set(ByVal trueFalse As Boolean)\n            _isDirty = trueFalse\n        End Set\n    End Property\n\n    Private Property IMyClass_IsDirty As Boolean Implements IMyClass.IsDirty\n        Get\n            Return _isDirty\n        End Get\n        Set(ByVal trueFalse As Boolean)\n            Throw New InvalidOperationException("Cannot set IsDirty through the interface")\n        End Set\n    End Property\nEnd Class