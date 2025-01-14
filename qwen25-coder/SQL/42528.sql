SELECT DISTINCT s.id, s.date, s.ip, s.browser, s.os, s.page, s.host, s.referer, s.query, s.agent \nFROM spy_hits s \nINNER JOIN (\n    SELECT ip, MAX(date) as max_date \n    FROM spy_hits \n    GROUP BY ip \n) latest_ips ON s.ip = latest_ips.ip AND s.date = latest_ips.max_date\nORDER BY s.date DESC \nLIMIT 10;