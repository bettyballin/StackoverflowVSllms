' Assuming MyClass is in the same namespace or default namespace of your project\nImports NamespaceName ' Replace with actual namespace if different\n\nPartial Class _Default\n    Inherits System.Web.UI.Page\n\n    Protected Sub Page_Load(ByVal sender As Object, ByVal e As EventArgs) Handles Me.Load\n        Dim myObject As New MyClass()\n        myObject.DoSomething()\n    End Sub\nEnd Class