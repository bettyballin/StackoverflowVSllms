Sub Main()\n    Dim myGenericDouble As New MyGeneric(Of Double)()\n    myGenericDouble.DoSomethingGeneric()\n\n    Dim myGenericString As New MyGeneric(Of String)()\n    myGenericString.DoSomethingGeneric()\nEnd Sub