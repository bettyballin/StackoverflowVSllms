Imports System.Collections.ObjectModel\n\nDim myList As List(Of String) = New List(Of String) From {"Item1", "Item2", "Item3"}\nDim observableCollection As ObservableCollection(Of String) = New ObservableCollection(Of String)(myList)