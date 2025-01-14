-- Continuing from the last known reply_count and blog_post_id for example\nSELECT bp.id AS blog_post_id, bp.title, COUNT(r.reply_id) AS reply_count\nFROM blog_posts bp\nLEFT JOIN replies r ON bp.id = r.blog_post_id\nWHERE (bp.reply_count < previous_reply_count)\n   OR (bp.reply_count = previous_reply_count AND bp.id > previous_blog_post_id)\nGROUP BY bp.id, bp.title\nORDER BY reply_count DESC, bp.id DESC\nLIMIT 30;