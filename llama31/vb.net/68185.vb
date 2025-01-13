Imports System.Data.Linq.SqlClient\n\nPublic Shared Function GetConcessions(ByVal Countries As String()) As IEnumerable\n    Dim CountryList As String = Utility.JoinArray(Countries)\n    Return (From t In New Db().Concessions _\n            Where SqlMethods.Like(CountryList, "%" + t.Country + "%") _\n            Select t.ConcessionID, t.Title, t.Country)\nEnd Functio