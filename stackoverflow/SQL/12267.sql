SELECT * FROM followers f\nLEFT JOIN activities a ON f.follower_id=a.user_id\nWHERE f.user_id=$followedPerso