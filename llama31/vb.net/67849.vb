Sub FilterTableList()\n    Dim db As DAO.Database\n    Dim td As DAO.TableDef\n    \n    Set db = CurrentDb()\n    \n    For Each td In db.TableDefs\n        If td.Owner = "YourOwnerName" Then\n            Debug.Print td.Name\n        End If\n    Next td\nEnd Sub