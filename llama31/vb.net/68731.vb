Imports System.Collections.ObjectModel\n\nPublic Class MyViewModel\n    Public Property MyCollection As New ObservableCollection(Of String)\n\n    Public Sub New()\n        MyCollection.Add("Item 1")\n        MyCollection.Add("Item 2")\n        MyCollection.Add("Item 3")\n        MyCollection.Add("Item 4")\n        MyCollection.Add("Item 5")\n    End Sub\nEnd Class