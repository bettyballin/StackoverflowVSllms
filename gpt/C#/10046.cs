[Route("api/[controller]")]\n   [ApiController]\n   public class MyServiceController : ControllerBase {\n       [HttpPost("MyMethod")]\n       public ActionResult<MyResponse> MyMethod([FromBody] MyRequest request) {\n           var response = new MyResponse { XmlData = "<response>...</response>", SomeInt = 42 };\n           return Ok(response);\n       }\n   }\n\n   public class MyRequest {\n       public string XmlData { get; set; }\n       public int SomeInt { get; set; }\n   }\n\n   public class MyResponse {\n       public string XmlData { get; set; }\n       public int SomeInt { get; set; }\n   }