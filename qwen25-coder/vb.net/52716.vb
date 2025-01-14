Public Class MyUserControl\n    Inherits System.Web.UI.UserControl\n\n    Protected Overrides Sub OnInit(ByVal e As EventArgs)\n        MyBase.OnInit(e)\n        ' Subscribe to the PreLoad event of the parent page\n        If Me.Page IsNot Nothing Then\n            AddHandler Me.Page.PreLoad, AddressOf Page_PreLoad\n        End If\n    End Sub\n\n    Private Sub Page_PreLoad(ByVal sender As Object, ByVal e As System.EventArgs)\n        ' Your code to execute during the PreLoad stage\n        Debug.WriteLine("Page is in PreLoad stage.")\n    End Sub\n\nEnd Class