Public Function Blah(t As Type) As Object\n    If Not t.GetInterfaces.Contains(GetType(IInterface)) Then\n        Throw New ArgumentException("The provided type must implement IInterface.")\n    End If\n    \n    ' Additional implementation here\n\nEnd Functio