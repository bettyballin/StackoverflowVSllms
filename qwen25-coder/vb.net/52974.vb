Dim q = From s In dc.STOCKs \n        Select s.ID, MemberPrice = _\n          (From mp In dc.STOCKPRICEs Where mp.NUMBER = s.NUMBER _\n           Order By mp.date Descending _\n           Select mp.PRICE).FirstOrDefault() ?? 0D