Imports System\n\n<AttributeUsage(AttributeTargets.Class)>\nPublic Class TestAttrAttribute\n    Inherits Attribute\n\n    Public Sub New(required1 As String, required2 As String)\n        Me.Required1 = required1\n        Me.Required2 = required2\n    End Sub\n\n    Public Property Required1 As String\n    Public Property Required2 As String\n    Public Property Optional1 As String = "default"\n    Public Property Optional2 As Integer = 0\nEnd Class\n\n<TestAttr("a", "abc", Optional1:="foo", Optional2:=3)>\nPublic Class ExampleClass\nEnd Class