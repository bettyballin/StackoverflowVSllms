Imports EnvDTE\nImports System.Diagnostics\n\nPublic Module TempModule\n    \n    Sub SelectCurrentLine()\n        Dim selection As TextSelection\n        selection = CType(DTE.ActiveDocument.Selection, TextSelection)\n        selection.SelectLine()\n    End Sub\n\nEnd Module