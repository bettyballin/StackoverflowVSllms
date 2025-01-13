-- Step 1: Calculate the sum of votes for each object_id\nWITH vote_sums AS (\n    SELECT object_id, SUM(vote) AS total_votes\n    FROM your_table\n    GROUP BY object_id\n)\n\n-- Step 2: Calculate the total sum of votes for the group (object_id 1 and 2)\n, group_total AS (\n    SELECT SUM(total_votes) AS group_sum\n    FROM vote_sums\n    WHERE object_id IN (1, 2)\n)\n\n-- Step 3: Normalize the votes for each object_id\nSELECT v.object_id, v.total_votes * 1.0 / g.group_sum AS normalized_score\nFROM vote_sums v\nJOIN group_total g ON 1 = 1\nWHERE v.object_id IN (1, 2);