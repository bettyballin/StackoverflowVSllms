SELECT COUNT(id) AS tag_count, `Tag` \nFROM `images-tags`\nGROUP BY `Tag`\nORDER BY tag_count DESC\nLIMIT 20;