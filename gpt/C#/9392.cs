try\n{\n    this.AppManager.DB.SubmitChanges();\n}\ncatch (ChangeConflictException)\n{\n    foreach (ObjectChangeConflict occ in this.AppManager.DB.ChangeConflicts)\n    {\n        // Resolve conflicts by keeping the current values\n        occ.Resolve(RefreshMode.KeepCurrentValues);\n    }\n    this.AppManager.DB.SubmitChanges();\n}