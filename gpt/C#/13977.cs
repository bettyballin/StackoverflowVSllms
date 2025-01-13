public void RecordUserVote(HttpContextBase context, int pictureId)\n{\n    var votesCookie = context.Request.Cookies["UserVotes"];\n    var votes = votesCookie?.Value.Split(',').Select(int.Parse).ToList() ?? new List<int>();\n\n    if (!votes.Contains(pictureId))\n    {\n        votes.Add(pictureId);\n        context.Response.Cookies.Add(new HttpCookie("UserVotes", string.Join(",", votes))\n        {\n            Expires = DateTime.Now.AddMonths(6) // Cookie expiration\n        });\n\n        // Optionally, record the vote server-side\n        var userId = GetOrCreateUserIdentifier(context);\n        RecordVoteServerSide(userId, pictureId);\n    }\n    else\n    {\n        // Handle case where the user has already voted for this picture\n    }\n}\n\npublic void RecordVoteServerSide(string userId, int pictureId)\n{\n    // Implement database logic to record the vote\n    // Example:\n    // var vote = new UserVote { UserId = userId, PictureId = pictureId };\n    // dbContext.UserVotes.Add(vote);\n    // dbContext.SaveChanges();\n}