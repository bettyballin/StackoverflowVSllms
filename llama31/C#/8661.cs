public IEnumerable<Comment> GetReplies(int commentID)\n{\n    var db = new DataClassesDataContext();\n    var visited = new HashSet<int>();\n\n    return GetRepliesRecursive(db, commentID, visited);\n}\n\nprivate IEnumerable<Comment> GetRepliesRecursive(DataClassesDataContext db, int commentID, HashSet<int> visited)\n{\n    if (visited.Contains(commentID)) return Enumerable.Empty<Comment>();\n\n    visited.Add(commentID);\n\n    var replies = db.Comments\n        .Where(c => c.ParentCommentID == commentID);\n\n    return replies.Concat(replies.SelectMany(reply => GetRepliesRecursive(db, reply.CommentID, visited)));\n}