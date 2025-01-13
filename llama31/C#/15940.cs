[ApiController]\n[Route("api/[controller]")]\npublic class MyController : ControllerBase\n{\n    [HttpGet]\n    public IActionResult GetData()\n    {\n        // Retrieve data from database\n        var data = MyDatabase.GetData();\n        return Ok(data);\n    }\n\n    [HttpPost]\n    public IActionResult ProcessData([FromBody] MyData data)\n    {\n        // Process data and store in database\n        MyDatabase.ProcessData(data);\n        return CreatedAtAction(nameof(GetData), new { id = data.Id });\n    }\n}