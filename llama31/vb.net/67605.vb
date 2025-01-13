Imports System.Collections.Concurrent\nImports System.Threading\n\nPrivate Shared _CompiledRegExes As New ConcurrentBag(Of Regex)\nPrivate Shared Regexes() As String = {"test1.Regex", "test2.Regex"}\nPrivate Shared RegExSetupLock As New Object\n\nPrivate Shared ReadOnly Property CompiledRegExes() As ConcurrentBag(Of Regex)\n    Get\n        If _CompiledRegExes.IsEmpty Then\n            SyncLock RegExSetupLock\n                If _CompiledRegExes.IsEmpty Then\n                    For Each exp As String In Parser.Regexes\n                        _CompiledRegExes.Add(New Regex(exp, RegexOptions.Compiled Or RegexOptions.CultureInvariant Or RegexOptions.IgnoreCase))\n                    Next\n                End If\n            End SyncLock\n        End If\n        Return _CompiledRegExes\n    End Get\nEnd Property