SELECT s.ThreadId, s.Function, s.HitCount\nFROM Samples s\nINNER JOIN (\n    SELECT ThreadId, MAX(HitCount) AS MaxHitCount\n    FROM Samples\n    WHERE FunctionId NOT IN (SELECT CalleeId FROM Callers)\n    GROUP BY ThreadId\n) sub ON s.ThreadId = sub.ThreadId AND s.HitCount = sub.MaxHitCount\nORDER BY s.ThreadId;