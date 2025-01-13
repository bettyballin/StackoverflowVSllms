Public Function CalcSqSum(Of T As Structure)(list As IEnumerable(Of T)) As T\n    If Not GetType(T).IsNumeric() Then\n        Throw New ArgumentException("Type must be numeric", NameOf(T))\n    End If\n\n    Dim sumSq As Object = CType(default(T), Object)\n\n    For Each item As Object In list\n        sumSq = CType(sumSq, Object) + CType(item, Object) * CType(item, Object)\n    Next\n\n    Return CType(sumSq, T)\nEnd Function\n\nPublic Function IsNumeric(type As Type) As Boolean\n    Return type = GetType(Integer) OrElse type = GetType(Double) OrElse type = GetType(Decimal) OrElse type = GetType(Single) OrElse type = GetType(Long) OrElse type = GetType(Short) OrElse type = GetType(Byte)\nEnd Functio