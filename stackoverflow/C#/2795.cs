var defaultRegions = from r in DefaultRegions\n             select r;\n\nIList<Region> rlist = new List<Region>();\nforeach(var dr in defaultRegions) {\n    var r = new Region {\n        Name = dr.Name };\n\n    foreach(DefaultSubRegion dsr in dr.DefaultSubRegions) {\n        var sr = new SubRegion {\n            Name = dsr.Name };\n\n        foreach(DefaultCountries dc in dsf.DefaultCountries) {\n            var c = new Country {\n                Name = dc.Name };\n\n            sr.Countries.Add(c);\n        }\n\n        r.SubRegions.Add(sr);\n   }\n\n   rlist.Add(r);\n}\n\nDataContext dc = new DataContext();\ndc.Regions.InsertAllOnSubmit(rlist);\ndc.Submit();