Imports System.Text.RegularExpressions\n\nModule Module1\n    Sub Main()\n        Dim input As String = "Check out this site: <a href=""http://www.stackoverflow.com"">stackoverflow</a>"\n        Dim output As String = FilterAnchorTags(input)\n        Console.WriteLine(output)\n    End Sub\n\n    Function FilterAnchorTags(input As String) As String\n        ' Regular expression to match anchor tags\n        Dim anchorPattern As String = "<a\s+(?:[^>]*?\s+)?href\s*=\s*[""'](.*?)[""'][^>]*>(.*?)</a>"\n        ' Replace anchor tags with the URL they contain\n        Dim result As String = Regex.Replace(input, anchorPattern, Function(m) m.Groups(1).Value)\n        Return result\n    End Function\nEnd Module