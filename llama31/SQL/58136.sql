SELECT v.*\nFROM videos v\nJOIN videos_categories vc ON v.video_id = vc.video_id\nWHERE vc.category_id IN (1, 2, 3)  -- replace with your selected categories\nGROUP BY v.video_id\nHAVING COUNT(DISTINCT vc.category_id) = 3  -- replace with the number of selected categories