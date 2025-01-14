SELECT \n    t.plant, \n    t.material,\n    Max(IIf(t.workcenter = 2, t.workcenter, null)) as Workcenter1,\n    Max(IIf(t.workcenter = 2, t.setuptime, null)) as Setuptime1,\n    Max(IIf(t.workcenter = 3, t.workcenter, null)) as Workcenter2,\n    Max(IIf(t.workcenter = 3, t.setuptime, null)) as Setuptime2\nFROM tmp t\nWHERE t.workcenter IN (2, 3)\nGROUP BY \n    t.plant, \n    t.material;\n\n-- Add additional queries for other workcenters if necessary.