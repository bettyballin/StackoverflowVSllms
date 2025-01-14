SELECT p.id, r.title, r.number\nFROM page p\nINNER JOIN (\n    SELECT pageId, MAX(number) AS maxNumber\n    FROM revision\n    GROUP BY pageId\n) rm ON p.id = rm.pageId AND rm.maxNumber = r.number;