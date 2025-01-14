Imports System.Reflection\n\nPublic Function CompareObjects(obj1 As Object, obj2 As Object) As Boolean\n    ' Get the type of both objects\n    Dim type1 = obj1.GetType()\n    Dim type2 = obj2.GetType()\n\n    ' If types are not the same, return false\n    If Not type1.Equals(type2) Then\n        Return False\n    End If\n\n    ' Get all properties of the type\n    Dim properties = type1.GetProperties(BindingFlags.Public Or BindingFlags.Instance)\n\n    ' Compare values of each property\n    For Each prop In properties\n        Dim val1 As Object = prop.GetValue(obj1)\n        Dim val2 As Object = prop.GetValue(obj2)\n\n        If Not Object.Equals(val1, val2) Then\n            Return False\n        End If\n    Next\n\n    ' All properties were equal\n    Return True\nEnd Functio