SELECT v.*\nFROM videos v\nJOIN videos_categories vc ON v.video_id = vc.video_id\nWHERE vc.category_id IN (1, 2, 3) -- Replace with your selected categories\nGROUP BY v.video_id\nHAVING COUNT(DISTINCT vc.category_id) = 3; -- This number must match the count of category IDs you are filtering by