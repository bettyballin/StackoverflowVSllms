var query = from p in context.Periods\n            join f in context.Facts on new { p.id, OtherId = 17 } equals new { id = f.periodid, f.otherid } into fg\n            from fgi in fg.DefaultIfEmpty()\n            where p.companyid == 100\n            select fgi.value;