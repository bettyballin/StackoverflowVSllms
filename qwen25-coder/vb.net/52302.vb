Public Partial Class Test\n    Inherits System.Web.UI.Page\n\n  Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load\n    If Not IsPostBack Then\n        Dim scriptName As String = HttpContext.Current.Request.ServerVariables("SCRIPT_NAME")\n        Response.Write(scriptName)\n    End If\n  End Sub\nEnd Class