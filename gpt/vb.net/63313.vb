Imports System.Collections.ObjectModel\n\nPublic Class YourViewModel\n    Public Property BusObjList As ObservableCollection(Of BusObj)\n\n    Public Sub New()\n        BusObjList = New ObservableCollection(Of BusObj)\n        ' Add initialization code here\n    End Sub\nEnd Class