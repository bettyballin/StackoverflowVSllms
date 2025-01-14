SELECT bp.id AS blog_post_id, bp.title, COUNT(r.reply_id) AS reply_count\nFROM blog_posts bp\nLEFT JOIN replies r ON bp.id = r.blog_post_id\nGROUP BY bp.id, bp.title\nORDER BY reply_count DESC\nLIMIT 30 OFFSET 60;