Dim obj As Object = Nothing\n   Dim result As String = IIf(SomeBoolean, obj.ToString(), "Default")\n   ' This will throw a NullReferenceException if obj is nothing and SomeBoolean is True.