Private Function RemoveHTMLTags(input As String) As String\n    Return System.Text.RegularExpressions.Regex.Replace(input, "<[^>]*>", "")\nEnd Function\n\n' Usage\nTextBox1.Text = RemoveHTMLTags(strString.ToString())