Imports NHibernate\n\nPublic Class GenericRepository(Of T As Class)\n    Public Sub Update(entity As T)\n        Using session As ISession = NHibernateHelper.OpenSession()\n            Using transaction As ITransaction = session.BeginTransaction()\n                Try\n                    session.Update(entity)\n                    transaction.Commit()\n                Catch ex As Exception\n                    transaction.Rollback()\n                    Throw\n                End Try\n            End Using\n        End Using\n    End Sub\n\n    ' You can also add other CRUD operations like Add, Delete, Get, etc.\n    Public Sub Add(entity As T)\n        Using session As ISession = NHibernateHelper.OpenSession()\n            Using transaction As ITransaction = session.BeginTransaction()\n                Try\n                    session.Save(entity)\n                    transaction.Commit()\n                Catch ex As Exception\n                    transaction.Rollback()\n                    Throw\n                End Try\n            End Using\n        End Using\n    End Sub\n\n    Public Sub Delete(entity As T)\n        Using session As ISession = NHibernateHelper.OpenSession()\n            Using transaction As ITransaction = session.BeginTransaction()\n                Try\n                    session.Delete(entity)\n                    transaction.Commit()\n                Catch ex As Exception\n                    transaction.Rollback()\n                    Throw\n                End Try\n            End Using\n        End Using\n    End Sub\n\n    Public Function GetById(id As Object) As T\n        Using session As ISession = NHibernateHelper.OpenSession()\n            Return session.Get(Of T)(id)\n        End Using\n    End Function\nEnd Class