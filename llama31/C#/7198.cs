using System;\nusing System.Web.Services;\n\n[WebService(Namespace = "http://tempuri.org/")]\n[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]\npublic class VotingService : WebService\n{\n    [WebMethod]\n    public int Vote(int id)\n    {\n        // Increment the vote count for the item with the given ID\n        // ...\n        return newVoteCount;\n    }\n}