using System.Web.Http;\npublic class SampleController : ApiController\n{\n    // GET api/sample/data\n    [HttpGet]\n    public IHttpActionResult GetData()\n    {\n        var data = new { Message = "Hello from Web API!" };\n        return Json(data);\n    }\n}