Type forumDataType = TypeResolver.ResolveType("ForumExtention.ForumData, ForumExtention");\nreturn View("~/Modules/Forums/Index.aspx", forumDataType, data);