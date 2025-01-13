' A shared variable in VB.NET is used to share a variable across all instances of a class.\n' It's essentially a class-level variable that is not tied to any specific instance.\n\nPublic Class MyClass\n    ' Shared variable\n    Public Shared mySharedVariable As Integer = 10\n\n    ' Non-shared variable\n    Public myNonSharedVariable As Integer = 20\nEnd Class\n\nModule Program\n    Sub Main()\n        ' Accessing the shared variable\n        Console.WriteLine(MyClass.mySharedVariable)\n\n        ' Creating instances of MyClass\n        Dim obj1 As New MyClass()\n        Dim obj2 As New MyClass()\n\n        ' Both instances share the same value for the shared variable\n        Console.WriteLine(obj1.mySharedVariable)\n        Console.WriteLine(obj2.mySharedVariable)\n\n        ' Changing the value of the shared variable\n        MyClass.mySharedVariable = 30\n\n        ' All instances now see the updated value\n        Console.WriteLine(obj1.mySharedVariable)\n        Console.WriteLine(obj2.mySharedVariable)\n    End Sub\nEnd Module