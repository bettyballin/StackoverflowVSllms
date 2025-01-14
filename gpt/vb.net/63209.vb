Imports System.IO\nImports System.Web.Mvc\n\nPublic Class CachedViewPage\n    Inherits System.Web.Mvc.ViewPage\n\n    Protected Overrides Sub Render(ByVal writer As HtmlTextWriter)\n        ' Create a StringWriter to capture the output\n        Dim stringView As String\n        Using sw As New StringWriter\n            Using w As New HtmlTextWriter(sw)\n                ' Temporarily replace the ViewContext's writer with our custom writer\n                Dim originalWriter = ViewContext.Writer\n                ViewContext.Writer = w\n\n                Try\n                    ' Call the base Render method to render the page\n                    MyBase.Render(w)\n                Finally\n                    ' Restore the original ViewContext's writer\n                    ViewContext.Writer = originalWriter\n                End Try\n\n                ' Get the rendered string\n                stringView = sw.ToString()\n            End Using\n        End Using\n\n        ' Write the captured output to the provided writer\n        writer.Write(stringView)\n    End Sub\nEnd Class