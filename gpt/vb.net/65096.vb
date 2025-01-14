Public Function GetRelativeTime(dateSubmitted As DateTime) As String\n    Dim timeDifference As TimeSpan = DateTime.Now - dateSubmitted\n\n    If timeDifference.TotalSeconds < 60 Then\n        Return "just now"\n    ElseIf timeDifference.TotalMinutes < 60 Then\n        Dim minutes As Integer = Math.Floor(timeDifference.TotalMinutes)\n        Return If(minutes = 1, "a minute ago", $"{minutes} minutes ago")\n    ElseIf timeDifference.TotalHours < 24 Then\n        Dim hours As Integer = Math.Floor(timeDifference.TotalHours)\n        Return If(hours = 1, "an hour ago", $"{hours} hours ago")\n    ElseIf timeDifference.TotalDays < 30 Then\n        Dim days As Integer = Math.Floor(timeDifference.TotalDays)\n        Return If(days = 1, "a day ago", $"{days} days ago")\n    ElseIf timeDifference.TotalDays < 365 Then\n        Dim months As Integer = Math.Floor(timeDifference.TotalDays / 30)\n        Return If(months = 1, "a month ago", $"{months} months ago")\n    Else\n        Dim years As Integer = Math.Floor(timeDifference.TotalDays / 365)\n        Return If(years = 1, "a year ago", $"{years} years ago")\n    End If\nEnd Functio