CREATE TABLE blog_table.`posts_relation` (\n`post_id` INT UNSIGNED NOT NULL ,\n`related_post_id` INT UNSIGNED NOT NULL ,\n`relation` FLOAT UNSIGNED NOT NULL ,\nINDEX ( `post_id` , `related_post_id` ) \n)