EXPLAIN SELECT min(`topic_id`) FROM `gallery_topics` \nWHERE `topic_id` > 11 \nAND `topic_poster` = 5 \nAND `topic_status` = 0;