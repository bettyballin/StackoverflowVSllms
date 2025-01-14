Imports System.Reflection\n\nPublic Sub DisplayAll(ByVal SomeObject As Foo)\n    ' Get the Type object for the class\n    Dim objType As Type = SomeObject.GetType()\n    \n    ' Loop through all properties of the class\n    For Each pi As PropertyInfo In objType.GetProperties(BindingFlags.Public Or BindingFlags.Instance)\n        ' Retrieve the property value using GetValue method and print it\n        Console.WriteLine(pi.Name & "=" & pi.GetValue(SomeObject))\n    Next\nEnd Sub