Imports System\n\nNamespace MyApp\n  Public Interface IMyInterface\n    Sub DoSomething()\n  End Interface\n\n  Public Class StubImplementation\n    Implements IMyInterface\n\n    Public Sub DoSomething() Implements IMyInterface.DoSomething\n      Console.WriteLine("Stub implementation")\n    End Sub\n  End Class\n\n  Public Class RealImplementation\n    Implements IMyInterface\n\n    Public Sub DoSomething() Implements IMyInterface.DoSomething\n      Console.WriteLine("Real implementation")\n    End Sub\n  End Class\n\n  Public Class Factory\n    Public Shared Function CreateInstance() As IMyInterface\n      If DEBUG Then\n        Return New StubImplementation()\n      Else\n        Return New RealImplementation()\n      End If\n    End Function\n  End Class\nEnd Namespace