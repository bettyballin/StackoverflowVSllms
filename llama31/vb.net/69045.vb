Private Function DataType(ByVal entry As Object) As ValueType\n    If TypeOf entry Is Integer Then\n        Return ValueType.Number\n    ElseIf TypeOf entry Is Boolean Then\n        Return ValueType.Boolean\n    ElseIf TypeOf entry Is Date Then\n        Return ValueType.Date\n    Else\n        Return ValueType.Text\n    End If\nEnd Functio