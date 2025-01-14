Imports System\nImports System.Linq.Expressions\nImports System.Reflection\n\nPublic Class A\n    Public Function Func() As B\n        Return New B()\n    End Function\nEnd Class\n\nPublic Class B\n    Public Function Name() As String\n        Return "a string"\n    End Function\nEnd Class\n\nModule Program\n    Sub Main()\n        Dim aInstance As New A()\n\n        ' Get MethodInfo for Func and Name methods\n        Dim funcMethod As MethodInfo = GetType(A).GetMethod("Func")\n        Dim nameMethod As MethodInfo = GetType(B).GetMethod("Name")\n\n        ' Create expression tree\n        Dim paramExpr As ParameterExpression = Expression.Parameter(GetType(A), "a")\n        Dim funcCallExpr As MethodCallExpression = Expression.Call(paramExpr, funcMethod)\n        Dim nameCallExpr As MethodCallExpression = Expression.Call(funcCallExpr, nameMethod)\n        \n        ' Compile the expression tree into a lambda function\n        Dim lambda As Expression(Of Func(Of A, String)) = Expression.Lambda(Of Func(Of A, String))(nameCallExpr, paramExpr)\n        Dim compiledLambda As Func(Of A, String) = lambda.Compile()\n\n        ' Invoke the compiled lambda function\n        Dim result As String = compiledLambda(aInstance)\n        Console.WriteLine(result)\n    End Sub\nEnd Module