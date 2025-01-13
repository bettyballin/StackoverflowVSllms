private List<int> searchedCommentIDs = new List<int>();\n\npublic IEnumerable<Comment> GetReplies(int commentID) {\n    using (var db = new DataClassesDataContext()) {\n        return GetRepliesInternal(db, commentID);\n    }\n}\n\nprivate IEnumerable<Comment> GetRepliesInternal(DataClassesDataContext db, int commentID) {\n    var replies = db.Comments\n        .Where(c => c.ParentCommentID == commentID && !searchedCommentIDs.Contains(c.CommentID))\n        .ToList();\n\n    foreach (var reply in replies) {\n        searchedCommentIDs.Add(reply.CommentID);\n        yield return reply;\n\n        foreach (var replyReply in GetRepliesInternal(db, reply.CommentID)) {\n            yield return replyReply;\n        }\n    }\n}