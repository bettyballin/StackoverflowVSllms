SELECT\n    referrer,\n    SUM(CASE\n        WHEN type = 'A' AND prev_referrals = 0 THEN comm_a1\n        WHEN type = 'A' AND prev_referrals = 1 THEN comm_a2\n        WHEN type = 'A' AND prev_referrals >= 2 THEN comm_a3\n        ELSE 0\n    END) AS Type_A_Comm,\n    SUM(CASE\n        WHEN type = 'A' THEN 1\n        ELSE 0\n    END) AS Type_A_Ref,\n    SUM(CASE\n        WHEN type = 'B' AND prev_referrals = 0 THEN comm_b1\n        WHEN type = 'B' AND prev_referrals = 1 THEN comm_b2\n        WHEN type = 'B' AND prev_referrals >= 2 THEN comm_b3\n        ELSE 0\n    END) AS Type_B_Comm,\n    SUM(CASE\n        WHEN type = 'B' THEN 1\n        ELSE 0\n    END) AS Type_B_Ref\nFROM (\n    SELECT\n        r1.referrer,\n        r1.type,\n        r1.date,\n        rc.comm_a1,\n        rc.comm_a2,\n        rc.comm_a3,\n        rc.comm_b1,\n        rc.comm_b2,\n        rc.comm_b3,\n        (SELECT COUNT(*)\n         FROM referrals r2\n         WHERE r2.referrer = r1.referrer AND r2.type = r1.type AND r2.date < r1.date) AS prev_referrals\n    FROM\n        referrals r1\n    JOIN\n        referrer_commissions rc ON r1.referrer = rc.referrer\n    WHERE\n        r1.date BETWEEN '2009-02-01' AND '2009-02-28'\n) AS commission_data\nGROUP BY\n    referrer;