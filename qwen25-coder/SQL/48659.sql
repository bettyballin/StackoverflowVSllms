SELECT gl.id, gl.site_id, gl.start, gl."end", gl.duration \nFROM generator_logs gl\nJOIN (\n    SELECT site_id, MAX(start) AS max_start \n    FROM generator_logs \n    GROUP BY site_id\n) AS latest ON gl.site_id = latest.site_id AND gl.start = latest.max_start\nORDER BY gl.start DESC;