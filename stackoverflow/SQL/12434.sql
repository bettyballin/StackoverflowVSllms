SELECT COUNT(id) AS theCount, `Tag` from `images-tags`\nGROUP BY `Tag`\nORDER BY theCount DESC\nLIMIT 20