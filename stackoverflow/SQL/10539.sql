SELECT blog_posts.*, count(replies.blog_post_id) as blog_replies \nFROM blog_posts \nLEFT JOIN replies ON replies.blog_post_id = blog_posts.id \nGROUP BY blog_posts.id \nORDER BY blog_replies DESC