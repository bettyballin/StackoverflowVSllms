Interface Interface1\n    Sub Method1()\nEnd Interface\n\nInterface Interface2\n    Sub Method2()\nEnd Interface\n\nClass MyClass\n    Implements Interface1, Interface2\n\n    Public Sub Method1() Implements Interface1.Method1\n        ' Implementation of Method1\n    End Sub\n\n    Public Sub Method2() Implements Interface2.Method2\n        ' Implementation of Method2\n    End Sub\nEnd Class