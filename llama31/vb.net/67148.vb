Imports System.Windows.Forms\n\nPublic Class CustomColorDialog\n    Inherits Form\n\n    Private colorPicker As New ColorPicker\n\n    Public Sub New()\n        Me.Size = New Size(400, 300) ' adjust size as needed\n        Me.Controls.Add(colorPicker)\n    End Sub\n\n    Public ReadOnly Property SelectedColor As Color\n        Get\n            Return colorPicker.Color\n        End Get\n    End Property\nEnd Class