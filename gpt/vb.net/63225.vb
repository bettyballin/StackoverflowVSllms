Partial Class WebPartA\n    Inherits System.Web.UI.UserControl\n\n    Protected Sub Button_Click(ByVal sender As Object, ByVal e As EventArgs)\n        ' Raise the shared event\n        EventManager.OnFillList(New SharedEventArgs())\n    End Sub\nEnd Class