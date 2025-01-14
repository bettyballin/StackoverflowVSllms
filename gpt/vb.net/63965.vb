Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n    If File.Exists("formSize.xml") Then\n        Dim serializer As New XmlSerializer(GetType(FormSize))\n        Using reader As New StreamReader("formSize.xml")\n            Dim formSize As FormSize = CType(serializer.Deserialize(reader), FormSize)\n            Me.Width = formSize.Width\n            Me.Height = formSize.Height\n        End Using\n    End If\nEnd Sub