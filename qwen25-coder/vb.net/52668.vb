Imports System.Reflection\n\nPublic Class MyClassExample\n    Public Property Foo1 As Integer\nEnd Class\n\nModule Module1\n    Sub Main()\n        Dim myObject As New MyClassExample()\n        Dim propertyName As String = GetPropertyName(Function() myObject.Foo1)\n        MessageBox.Show(propertyName & " is the variable you are looking for.")\n        ' Outputs: Foo1 is the variable you are looking for.\n    End Sub\n\n    Private Function GetPropertyName(Of T, V)(ByVal propertyExpression As Expression(Of Func(Of T, V))) As String\n        Dim memberExpression = CType(propertyExpression.Body, MemberExpression)\n        Return memberExpression.Member.Name\n    End Function\nEnd Module