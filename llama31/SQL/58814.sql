SELECT video_name \nFROM videos \nINNER JOIN videotags ON videos.id=videotags.video_id \nINNER JOIN tags ON tags.id=videotags.tag_id \nWHERE tag_name IN ('x', 'y', 'z') \nAND videos.id <> 'current_video_id' \nGROUP BY videos.id \nHAVING COUNT(DISTINCT tag_name) > 1 \nLIMIT 5;