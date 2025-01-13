using System;\nusing System.Data;\nusing System.Linq;\n\npublic void PerformSelection(DataSet ds)\n{\n    var parentTabIds = ds.Tables["ParentTabs"]\n                          .AsEnumerable()\n                          .Select(row => row.Field<int>("fsp_fsid"))\n                          .ToList();\n\n    DataRow[] selectedRows = ds.Tables["FilingTabs"]\n                               .AsEnumerable()\n                               .Where(row => !parentTabIds.Contains(row.Field<int>("fs_ID")))\n                               .ToArray();\n}