Dim db As DAO.Database\nDim td As DAO.TableDef\nDim fld As DAO.Field\n\nSet db = OpenDatabase("your_database_path")\nSet td = db.TableDefs("your_table_name")\nSet fld = td.Fields("your_column_name")\n\nfld.Type = DAO.DataTypeEnum.dbLong\ntd.Fields.Refresh\n\nSet fld = Nothing\nSet td = Nothing\nSet db = Nothing