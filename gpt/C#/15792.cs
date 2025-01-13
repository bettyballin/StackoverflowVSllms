using System.Web.Services;\nusing System.Web.Script.Serialization;\n\n[WebService(Namespace = "http://tempuri.org/")]\n[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]\n[System.ComponentModel.ToolboxItem(false)]\npublic class VotingService : WebService\n{\n    [WebMethod]\n    public void Upvote(int itemId)\n    {\n        // Perform the upvote action (e.g., increment the vote count in the database)\n        int newVoteCount = YourDataAccessLayer.UpvoteItem(itemId);\n\n        // Return the new vote count as a JSON response\n        var json = new JavaScriptSerializer().Serialize(new { voteCount = newVoteCount });\n        Context.Response.ContentType = "application/json";\n        Context.Response.Write(json);\n    }\n}