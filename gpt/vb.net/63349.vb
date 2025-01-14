Public Class KosherTypes\n\n    Public Shared Function GetKosherTypes() As List(Of KosherTypeLookup)\n        Using db As New DBDataContext\n            Dim types = From kt In db.KosherTypes _\n                        Where kt.IsDeleted = False _\n                        Order By kt.Name _\n                        Select New KosherTypeLookup With {.Name = kt.Name, .ID = kt.KosherTypeID}\n\n            Return types.ToList()\n        End Using\n    End Function\n\nEnd Class