Public Class A\n    ' Properties and methods of class A\nEnd Class\n\nPublic Class B\n    ' Properties and methods of class B\nEnd Class\n\n' Usage in another part of your code\nDim collectionOfA As New GenericCollection(Of A)\ncollectionOfA.Add(New A())\nConsole.WriteLine("Count of A: " & collectionOfA.Count)\n\nDim collectionOfB As New GenericCollection(Of B)\ncollectionOfB.Add(New B())\nConsole.WriteLine("Count of B: " & collectionOfB.Count)