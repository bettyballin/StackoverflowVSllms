' In your Web User Control (.ascx.vb)\nPublic Class MyUserControl\n    Public Event CustomError As EventHandler(Of ExceptionEventArgs)\n\n    Protected Sub RaiseCustomError(ex As Exception)\n        If CustomError IsNot Nothing Then\n            RaiseEvent CustomError(Me, New ExceptionEventArgs(ex))\n        Else\n            ' Fallback: Log error or throw to be caught by Global.asax if no event handler is attached\n            Throw ex\n        End If\n    End Sub\n\n    Protected Sub SomeMethodThatCanThrowException()\n        Try\n            ' Simulate some operation that can fail\n            Throw New InvalidOperationException("Something went wrong!")\n        Catch ex As Exception\n            RaiseCustomError(ex)\n        End Try\n    End Sub\nEnd Class\n\n' Define a custom EventArgs to hold the exception\nPublic Class ExceptionEventArgs\n    Inherits EventArgs\n\n    Public ReadOnly Property Exception As Exception\n\n    Public Sub New(exception As Exception)\n        Me.Exception = exception\n    End Sub\nEnd Class\n\n' Handling the event in your page (.aspx.vb) where you use the user control\nPublic Partial Class MyPage\n    Protected Sub Page_Load(ByVal sender As Object, ByVal e As EventArgs) Handles Me.Load\n        AddHandler UserControl1.CustomError, AddressOf HandleCustomError\n    End Sub\n\n    Private Sub HandleCustomError(sender As Object, e As ExceptionEventArgs)\n        ' Redirect or handle exception here\n        Response.Redirect("~/ErrorPage.aspx?message=" & Server.UrlEncode(e.Exception.Message))\n    End Sub\nEnd Class