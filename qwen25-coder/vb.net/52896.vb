Public Class DerivedClass Inherits Test\n\n    Public Sub ExampleUsage()\n        Dim testInstance As New Test()\n\n        ' Accessing case-sensitive field A\n        testInstance.A = 1\n\n        ' Accessing case-sensitive field a\n        testInstance.[a] = 2\n\n        Console.WriteLine("A: " & testInstance.A)\n        Console.WriteLine("a: " & testInstance.[a])\n    End Sub\n\nEnd Class