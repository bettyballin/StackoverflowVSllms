Imports System.Collections.Generic\n\n' Define a custom Comparer for sorting keys as integers\nPublic Class TimeSlotComparer\n    Implements IComparer(Of String)\n\n    Public Function Compare(x As String, y As String) As Integer Implements IComparer(Of String).Compare\n        ' Split the strings to get start times and convert them to integers\n        Dim startX As Integer = Convert.ToInt32(x.Split("-"c)(0))\n        Dim startY As Integer = Convert.ToInt32(y.Split("-"c)(0))\n        \n        ' Compare based on the start time as integer\n        Return startX.CompareTo(startY)\n    End Function\nEnd Class\n\n' Usage of SortedDictionary with custom comparer\nDim sortedDict As New SortedDictionary(Of String, List(Of Object))(New TimeSlotComparer())\n\n' Adding elements to the dictionary\nsortedDict.Add("700-800", New List(Of Object)())\nsortedDict.Add("900-1000", New List(Of Object)())\nsortedDict.Add("1100-1200", New List(Of Object)())\nsortedDict.Add("1700-1800", New List(Of Object)())\nsortedDict.Add("1900-2000", New List(Of Object)())\n\n' Output the sorted dictionary\nFor Each kvp In sortedDict\n    Console.WriteLine(kvp.Key)\nNext