Namespace WindowsFormsApplication1\n    Partial Public Class Form1\n        Inherits Form\n        Private oldcolor As Integer\n\n        Public Sub New()\n            InitializeComponent()\n            oldcolor = GetSysColor(COLOR_WINDOW)\n            AddHandler Me.FormClosed, AddressOf Form1_FormClosed\n            AddHandler Button1.Click, AddressOf button1_Click\n        End Sub\n\n        Private Sub Form1_FormClosed(ByVal sender As Object, ByVal e As FormClosedEventArgs) Handles MyBase.FormClosed\n            SetSysColor(COLOR_WINDOW, oldcolor)\n        End Sub\n\n        Private Function Color2COLORREF(ByVal color As Color) As Integer\n            Return color.R Or (color.G << 8) Or (color.B << &H10)\n        End Function\n\n        Private Sub button1_Click(ByVal sender As Object, ByVal e As EventArgs) Handles Button1.Click\n            Dim colorref As Integer = Color2COLORREF(Color.NavajoWhite)\n            SetSysColor(COLOR_WINDOW, colorref)\n        End Sub\n\n        Private Const COLOR_WINDOW As Integer = 5\n        <DllImport("user32.dll")>\n        Private Shared Function SetSysColor(ByVal nIndex As Integer, ByVal crColor As UInteger) As Boolean\n        End Function\n\n        <DllImport("user32.dll")>\n        Private Shared Function GetSysColor(ByVal nIndex As Integer) As Integer\n        End Function\n\n        Friend WithEvents Button1 As System.Windows.Forms.Button\n        Private Sub InitializeComponent()\n            Me.Button1 = New System.Windows.Forms.Button\n            Me.SuspendLayout()\n            '\n            'Button1\n            '\n            Me.Button1.Location = New System.Drawing.Point(71, 61)\n            Me.Button1.Name = "Button1"\n            Me.Button1.Size = New System.Drawing.Size(153, 126)\n            Me.Button1.TabIndex = 0\n            Me.Button1.Text = "Set Background Color"\n            Me.Button1.UseVisualStyleBackColor = True\n            '\n            'Form1\n            '\n            Me.ClientSize = New System.Drawing.Size(284, 264)\n            Me.Controls.Add(Me.Button1)\n            Me.Name = "Form1"\n            Me.ResumeLayout(False)\n\n        End Sub\n    End Class\nEnd Namespace