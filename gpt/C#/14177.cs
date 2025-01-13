[Route("api/[controller]")]\n    public class MyComController : ControllerBase\n    {\n        [HttpPost]\n        [Route("MyComMethod")]\n        public IActionResult MyComMethod([FromBody] string input)\n        {\n            // Call the COM component here\n            var comObject = new MyComComponent();\n            var result = comObject.SomeMethod(input);\n            return Ok(result);\n        }\n    }