Public Class BaseClass\n      Public Sub Show()\n          Console.WriteLine("Base Class")\n      End Sub\n  End Class\n\n  Public Class DerivedClass\n      Inherits BaseClass\n\n      ' Hides the base class method with a new method\n      Public Shadows Sub Show()\n          Console.WriteLine("Derived Class")\n      End Sub\n  End Class