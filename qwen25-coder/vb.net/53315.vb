Imports System.Reflection\n\n' Assuming oReader is your reader and Me.Elements is the object whose properties you want to set\nDim propertyName As String = oReader.Name\nDim propertyValue As String = oReader.ReadString()\n\n' Get the type of Me.Elements\nDim elementType As Type = Me.Elements.GetType()\n\n' Use reflection to get the PropertyInfo for the property with the given name\nDim propInfo As PropertyInfo = elementType.GetProperty(propertyName)\n\nIf propInfo IsNot Nothing AndAlso propInfo.CanWrite Then\n    ' Set the value of the property\n    propInfo.SetValue(Me.Elements, propertyValue)\nElse\n    ' Handle the case where the property does not exist or is read-only\n    Console.WriteLine($"Property {propertyName} not found or cannot be set.")\nEnd If