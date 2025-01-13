Partial Class BasePage\n    Inherits System.Web.UI.Page\n\n    Protected Overrides Sub OnPreInit(ByVal e As EventArgs)\n        MyBase.OnPreInit(e)\n\n        ' Assuming you have a way to determine the current theme\n        Dim currentTheme As String = GetCurrentTheme() ' Implement this method to get the current theme\n\n        ' Set the master page based on the theme\n        Me.MasterPageFile = "~/themes/" & currentTheme & "/site.master"\n    End Sub\n\n    Private Function GetCurrentTheme() As String\n        ' Logic to determine the current theme\n        ' For example, it might be based on user preferences, query string, etc.\n        Return "Indigo" ' Placeholder, replace with actual logic\n    End Function\nEnd Class