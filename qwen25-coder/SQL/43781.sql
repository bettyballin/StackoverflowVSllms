WHERE grp1 * grp2 * grp3 * ... * grpn = 0\n   OR (grp2 <> 0 AND grp1 <> 0)\n   AND (grp3 <> 0 AND grp2 <> 0)\n   AND ...\n   AND (grpn <> 0 AND grp(n-1) <> 0)