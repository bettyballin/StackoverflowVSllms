Function GetValues() As List(Of YourDataType)\n    Dim data = ' retrieve data from database via stored proc\n    For Each item In data\n        item.DateTimeSubmitted = NiceDate(item.DateTimeSubmitted)\n    Next\n    Return data\nEnd Functio