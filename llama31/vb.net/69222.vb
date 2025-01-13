Imports System.Reflection\nImports System.Linq.Expressions\n\nPublic Class Blah\n    Public Sub Foo()\n    End Sub\n\n    Public Shared Function GetMethodName(Of T)(expr As Expression(Of Action(Of T))) As String\n        Dim methodCallExpr = TryCast(expr.Body, MethodCallExpression)\n        If methodCallExpr IsNot Nothing Then\n            Return methodCallExpr.Method.Name\n        End If\n        Throw New ArgumentException("Expression is not a method call")\n    End Function\nEnd Class\n\nModule Module1\n    Sub Main()\n        Dim blahInstance As New Blah()\n        Dim methodName = Blah.GetMethodName(Of Blah)(Function(x) x.Foo())\n        Console.WriteLine(methodName)  ' Outputs: Foo\n    End Sub\nEnd Module