Public Function GetDefaultValue(Of T)() As T\n        If GetType(T) Is GetType(MyCustomType) Then\n            Return CType(CType(New MyCustomType(), Object), T)\n        End If\n        Return Nothing\n    End Functio