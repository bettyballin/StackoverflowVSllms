from p in context.Periods\njoin f in context.Facts \n    on new { Id = p.id, OtherId = 17 } equals new { Id = f.periodid, OtherId = f.otherid } into fg\nfrom fgi in fg.DefaultIfEmpty()\nwhere p.companyid == 100\nselect fgi.value