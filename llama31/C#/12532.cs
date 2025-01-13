var auta = from a in MtAuta.FindAll()\n           join p in DtPoruchy.FindAll() on a.Id equals p.IdAuta into ap\n           from ap2 in ap.DefaultIfEmpty()\n           where ap2 != null && ap2.Servis >= 3\n           group ap2 by a.Id into grouped\n           select new\n           {\n               SumCena = grouped.Sum(x => x.Cena),\n               IdAuta = grouped.Key,\n               MaxServis = grouped.Max(x => x.Servis)\n           };