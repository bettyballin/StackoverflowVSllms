select p.PTNO, p.PTNM, p.CATCD\n  from PARTS p\n  left join CATEGORIES c on c.CATCD = p.CATCD\n  left join SECTIONS s on s.SECCD = p.SECCD;