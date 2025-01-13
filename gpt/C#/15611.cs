var zipLinqQuery =\n    from z in db.ZIPMASTERs\n    where z.CORP == 12\n    && z.ZIPBEG.CompareTo("85546 ") <= 0\n    && z.ZIPEND.CompareTo("85546 ") >= 0\n    select z;\n\nList<ZIPMASTER> zips = zipLinqQuery.ToList<ZIPMASTER>();