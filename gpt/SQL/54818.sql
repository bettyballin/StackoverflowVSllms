SELECT COUNT(*) AS c\nFROM BANS\nWHERE typeid=6\n  AND (\n    INET6_ATON('::1') & (CAST(CONV(REPEAT('f', cidr/4) & LPAD('', 32 - cidr/4, '0'), 16, 10) AS UNSIGNED) << (128 - cidr))\n    = \n    ipaddr & (CAST(CONV(REPEAT('f', cidr/4) & LPAD('', 32 - cidr/4, '0'), 16, 10) AS UNSIGNED) << (128 - cidr))\n  );