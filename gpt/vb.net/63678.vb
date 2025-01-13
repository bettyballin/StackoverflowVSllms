Public Class ErrorSummary\n    Inherits BaseValidator\n\n    Public Sub New(ByVal message As String, ByVal validationGroup As String)\n        MyBase.ErrorMessage = message\n        MyBase.ValidationGroup = validationGroup\n        MyBase.IsValid = False\n    End Sub\n\n    Public Sub New(ByVal message As String)\n        Me.New(message, String.Empty)\n    End Sub\n\n    Public Shared Sub AddError(ByVal message As String, ByVal page As Page)\n        AddError(message, String.Empty, page)\n    End Sub\n\n    Public Shared Sub AddError(ByVal message As String, ByVal validationGroup As String, ByVal page As Page)\n        Dim objError As New ErrorSummary(message, validationGroup)\n        page.Validators.Add(objError)\n    End Sub\n\n    Protected Overrides Function EvaluateIsValid() As Boolean\n        Return False\n    End Function\n\n    Protected Overrides Sub Render(ByVal writer As HtmlTextWriter)\n        ' Ensure that the error message is rendered correctly\n        If Not Me.IsValid Then\n            writer.Write(Me.ErrorMessage)\n        End If\n    End Sub\nEnd Class