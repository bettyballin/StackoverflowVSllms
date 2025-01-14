Imports System.ComponentModel\n\n<EditorBrowsable(EditorBrowsableState.Always),\n Browsable(True),\n Bindable(True),\n DesignerSerializationVisibility(DesignerSerializationVisibility.Visible)> _\nOverrides Property Text() As String\n    Get\n        Return Me.ControlText.Text ' Ensure you use `Me` to refer to the control's Label or relevant control member.\n    End Get\n    Set(value As String)\n        Me.ControlText.Text = value\n    End Set\nEnd Property