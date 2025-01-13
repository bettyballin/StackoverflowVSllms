SELECT \n  har_autos.*,\n  har_automodels.Model,\n  har_automodels.MakeID,\n  har_automakes.Make,\n  har_autotypes.AutoType,\n  CONCAT('<Notes>', \n    GROUP_CONCAT(\n      CONCAT(\n        '<Note>',\n        har_notes.ID,\n        '</Note>'\n      )\n      SEPARATOR ''\n    ),\n    '</Notes>'\n  ) AS UserNotes,\n  CONCAT('<Notes>', \n    GROUP_CONCAT(\n      CONCAT(\n        '<Note>',\n        har_notes.ID,\n        '</Note>'\n      )\n      SEPARATOR ''\n    ),\n    '</Notes>'\n  ) AS EngineeringNotes\nFROM \n  har_autos\n  LEFT JOIN har_automodels ON (har_autos.ModelID = har_automodels.ID)\n  LEFT JOIN har_automakes ON (har_automodels.MakeID = har_automakes.ID)\n  LEFT JOIN har_autotypes ON (har_autos.AutoTypeID = har_autotypes.ID)\n  LEFT JOIN (\n    SELECT \n      har_notes.ID,\n      har_notelinks.AutoID\n    FROM \n      har_notes\n      JOIN har_notelinks ON (har_notes.ID = har_notelinks.NoteID)\n    WHERE \n      har_notes.NoteTypeID = 1\n  ) AS UserNotes ON (har_autos.ID = UserNotes.AutoID)\n  LEFT JOIN (\n    SELECT \n      har_notes.ID,\n      har_notelinks.AutoID\n    FROM \n      har_notes\n      JOIN har_notelinks ON (har_notes.ID = har_notelinks.NoteID)\n    WHERE \n      har_notes.NoteTypeID = 2\n  ) AS EngineeringNotes ON (har_autos.ID = EngineeringNotes.AutoID)\nGROUP BY \n  har_autos.ID