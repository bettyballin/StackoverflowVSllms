UPDATE people\nSET prize = CASE\n    WHEN id = <person_id> THEN 'Gold'\n    ELSE ''\nEND\nWHERE class = (SELECT class FROM (SELECT class FROM people WHERE id = <person_id>) AS subquery);