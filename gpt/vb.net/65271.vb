<BindEvent("E")>\nPublic ReadOnly Property IsTrue() As Boolean\n    Get\n        Return True\n    End Get\nEnd Property\n\nPublic Sub Test_Handler(ByVal sender As Object, ByVal e As EventArgs) Handles E\n    ' Handle the event here\nEnd Sub