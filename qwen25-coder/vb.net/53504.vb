Dim db As DAO.Database\nDim tdf As DAO.TableDef\nDim fld As DAO.Field\n\nSet db = CurrentDb()\nSet tdf = db.TableDefs("MyTable")\n\n' Create a new field with the desired number of decimal places\nSet fld = tdf.CreateField("MyField", dbCurrency) ' dbCurrency is used here, but you can also use dbDouble\nfld.DecimalPlaces = 4 ' Set the number of decimal places\n\n' Append the field to the table definition\ntdf.Fields.Append fld\n\nSet fld = Nothing\nSet tdf = Nothing\nSet db = Nothing