Public Class frmMain\n    ' Private field for lazy initialization\n    Private _dlgAdd As frmAdd = Nothing\n\n    ' Public read-only property to access the dialog\n    Public ReadOnly Property DlgAdd() As frmAdd\n        Get\n            If _dlgAdd Is Nothing Then\n                _dlgAdd = New frmAdd()\n            End If\n            Return _dlgAdd\n        End Get\n    End Property\n\n    ' Other methods that don't directly use _dlgAdd\n    Public Sub DoStuff()\n        ' Implementation here, does not touch _dlgAdd\n    End Sub\n\n    ' Optionally, provide a method to reset the dialog if needed\n    Public Sub ResetDlgAdd()\n        _dlgAdd = Nothing\n    End Sub\nEnd Class