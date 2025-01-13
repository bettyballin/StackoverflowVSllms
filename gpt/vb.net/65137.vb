Public Class BaseClass\n    Public Overridable Sub VirtualMethod()\n        Console.WriteLine("BaseClass implementation.")\n    End Sub\nEnd Class\n\nPublic Class DerivedClass\n    Inherits BaseClass\n\n    Public Overrides Sub VirtualMethod()\n        Console.WriteLine("DerivedClass implementation.")\n    End Sub\nEnd Class