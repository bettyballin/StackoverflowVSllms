' Create an array of childObject with the correct type\nDim ResponseChildren(1) As childObject\n\nFor i As Integer = 0 To Results.Length - 1\n    Dim ResultSet As String() = Results(i).Split(",")\n    \n    ' Create a new instance of childObject for each entry in Results\n    ResponseChildren(i) = New childObject()\n    \n    ' Get the properties of the childObject\n    Dim PropInfo As PropertyInfo() = GetType(childObject).GetProperties()\n    \n    For j As Integer = 0 To ResultSet.Length - 1\n        ' Set the values of the properties using reflection\n        PropInfo(j).SetValue(ResponseChildren(i), ResultSet(j))\n    Next\nNext\n\n' Get the property info for the child array in the parent object\nDim ParentPropInfo As PropertyInfo = ResponseObject.GetType().GetProperty("child")\n\n' Use SetValue to assign the correctly typed array to the parent's property\nParentPropInfo.SetValue(ResponseObject, ResponseChildren)