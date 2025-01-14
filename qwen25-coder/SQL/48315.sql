SELECT ud.user_id, ud.username  -- Adjust columns as necessary\nFROM user_details ud\nJOIN skills s ON ud.user_id = s.user_id\nWHERE s.skill_id IN (51, 52, 53, 54, 55)\nGROUP BY ud.user_id\nHAVING COUNT(DISTINCT s.skill_id) = 5;  -- This should be the number of skill_ids you are filtering by