Public Class MyForm\n    ' Declare the button without WithEvents\n    Private button1 As System.Windows.Forms.Button\n\n    Public Sub New()\n        InitializeComponent()\n        AddHandler Me.button1.Click, AddressOf Me.OK_ButtonClick\n    End Sub\n\n    ' Manually define the event handler method\n    Private Sub OK_ButtonClick(sender As Object, e As EventArgs)\n        Me.DialogResult = System.Windows.Forms.DialogResult.OK\n        Me.Close()\n    End Sub\nEnd Class