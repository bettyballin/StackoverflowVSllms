SqlQuery q = new Select().From<VwInstitutes>();\n\nif (!string.IsNullOrEmpty(username))\n{\n    q = q.HasWhere ? q.And(VwInstitutes.Columns.AssignedUser).IsEqualTo(username) \n                  : q.Where(VwInstitutes.Columns.AssignedUser).IsEqualTo(username);\n}\n\nif (!string.IsNullOrEmpty(stage))\n{\n    q = q.HasWhere ? q.And(VwInstitutes.Columns.Stage).IsEqualTo(stage) \n                  : q.Where(VwInstitutes.Columns.Stage).IsEqualTo(stage);\n}