Protected Sub Page_Init(ByVal sender As Object, ByVal e As EventArgs) Handles Me.Init\n    If Not IsPostBack Then\n        RenderControls()\n    End If\nEnd Sub\n\nProtected Sub Button1_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles Button1.Click\n    RenderControls()\nEnd Sub\n\nPrivate Sub RenderControls()\n    Dim Survey As New Survey\n    Survey.RenderPage(PlaceHolder1)\nEnd Sub