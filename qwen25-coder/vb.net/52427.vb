Partial Class _Default\n    Inherits System.Web.UI.Page\n\n    Protected Sub Page_Load(ByVal sender As Object, ByVal e As EventArgs) Handles Me.Load\n        ' Example of retrieving a GET variable named "myVariable"\n        Dim myValue As String = Request.QueryString("myVariable")\n\n        If Not String.IsNullOrEmpty(myValue) Then\n            ' Use the value as needed\n            Response.Write("The value is: " & Server.HtmlEncode(myValue))\n        Else\n            ' Handle case where the query string parameter is not provided\n            Response.Write("No value was found for myVariable.")\n        End If\n    End Sub\nEnd Class