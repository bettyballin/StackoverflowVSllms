Dim db As DAO.Database\nDim tdf As DAO.TableDef\nDim fld As DAO.Field\n\nSet db = CurrentDb()\nSet tdf = db.CreateTableDef("MyTable")\nSet fld = tdf.CreateField("ID", dbLong)\ntdf.Fields.Append fld\nSet fld = tdf.CreateField("Name", dbText, 255)\ntdf.Fields.Append fld\ndb.TableDefs.Append tdf