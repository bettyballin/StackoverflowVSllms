' In Form2 (the form receiving the data)\nPublic Class Form2\n    Public Sub New(data As String)\n        InitializeComponent()\n        ' Use the passed data as needed\n        Me.Label1.Text = data\n    End Sub\nEnd Class\n\n' In Form1 (the form sending the data)\nPrivate Sub Button_Click(sender As Object, e As EventArgs) Handles Button.Click\n    Dim sendData As String = "Hello from Form1"\n    Dim newForm As New Form2(sendData)\n    newForm.Show()\nEnd Sub