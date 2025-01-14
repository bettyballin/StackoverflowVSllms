update prospekts\nset sni_kod = case\n    when sni_kod_int >= 1000 and sni_kod_int <= 1499 \n        or sni_kod_int >= 1600 and sni_kod_int <= 2439\n    then '1'\n    when sni_kod_int >= 7000 and sni_kod_int <= 7499 \n    then 'W'\n    else sni_kod\nend\nfrom (\n    select sni_kod, cast(sni_kod as int) as sni_kod_int\n    from prospekts\n) as derived\nwhere prospekts.sni_kod = derived.sni_kod;