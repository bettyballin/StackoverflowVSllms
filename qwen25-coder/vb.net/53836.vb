' In VB.NET, add reference to C# class library project:\nImports MyCSharpNamespace\n\nPublic Class VBClass\n    Public Sub UseCSharpMethod()\n        Dim csharpInstance As New CSharpClass()\n        csharpInstance.SomeMethod()\n    End Sub\nEnd Class