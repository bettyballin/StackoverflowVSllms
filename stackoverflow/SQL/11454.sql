select gl.id, gl.site_id, gl.start, gl."end", gl.duration \nfrom \n    generator_logs gl\n    inner join (\n        select max(start) as start, site_id\n        from generator_logs \n        group by site_id\n    ) gl2\n        on gl.site_id = gl2.site_id\n        and gl.start = gl2.start