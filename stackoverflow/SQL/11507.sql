select distinct PO \nfrom POPI x \nwhere \n  PO not in (\n    select PO \n    from POPI \n    where PI not in (10,11,12)\n  ) \n  and PI not in (\n    select PI \n    from POPI \n    where PO != x.PO \n      and PO not in (\n        select PO \n        from POPI \n        where PI not in (10,11,12)\n      )\n  );