Structure Person\n      Public name As String\n  End Structure\n\n  Dim someone As Person = Nothing ' This is valid; name will be set to ""\n  Dim isSomeoneNull As Boolean = someone.Equals(Nothing) ' Still returns False because someone is a value type, not null\n\n  ' To make it nullable in VB.NET, use Nullable(Of T)\n  Dim someoneElse As Nullable(Of Person) = Nothing\n  Dim isSomeoneElseNull As Boolean = someoneElse.HasValue ' Returns False