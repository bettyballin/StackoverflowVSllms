public bool IsDuplicatePost(string postContent)\n{\n    using (var context = new YourDbContext())\n    {\n        return context.Posts.Any(p => p.Content == postContent);\n    }\n}\n\nprotected void SubmitButton_Click(object sender, EventArgs e)\n{\n    string postContent = Request.Form["postContent"];\n    if (!IsDuplicatePost(postContent))\n    {\n        SavePostToDatabase(postContent);\n    }\n    else\n    {\n        // Handle duplicate post\n    }\n}\n\nprivate void SavePostToDatabase(string postContent)\n{\n    using (var context = new YourDbContext())\n    {\n        var newPost = new Post { Content = postContent };\n        context.Posts.Add(newPost);\n        context.SaveChanges();\n    }\n}