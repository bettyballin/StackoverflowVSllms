var result = dateTable\n             .Where(d => d.category == "someCat")\n             .SelectMany(d => tvFunction(d.dt, "anotherParam"),\n                         (d, tvf) => new \n                         {\n                             d.dateCol,\n                             tvf.descr,\n                             tvf.value\n                         });