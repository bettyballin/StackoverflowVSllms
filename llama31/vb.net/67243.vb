Imports System.Text.RegularExpressions\n\nPublic Function RemoveAnchorTags(text As String) As String\n    Return Regex.Replace(text, "<a.*?href=""([^""]*)"".*?>(.*?)</a>", "$1")\nEnd Functio