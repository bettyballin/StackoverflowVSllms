public class ReviewsController : ApiController\n{\n    [HttpGet]\n    public HttpResponseMessage GetReviews(string callback)\n    {\n        var reviews = new List<string>\n        {\n            "Review 1",\n            "Review 2",\n            "Review 3"\n        };\n\n        var json = JsonConvert.SerializeObject(reviews);\n        var response = $"{callback}({json})";\n\n        var httpResponse = new HttpResponseMessage(HttpStatusCode.OK);\n        httpResponse.Content = new StringContent(response, Encoding.UTF8, "application/javascript");\n\n        return httpResponse;\n    }\n}