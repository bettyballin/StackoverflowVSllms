Imports System.Collections\n\nPublic Class MyInteropControl\n    Public Event PassNames(ByVal names As ArrayList)\n\n    Public Sub TriggerPassNames()\n        Dim nameList As New ArrayList()\n        nameList.Add("Name1")\n        nameList.Add("Name2")\n        ' Add more names as needed\n        RaiseEvent PassNames(nameList)\n    End Sub\nEnd Class