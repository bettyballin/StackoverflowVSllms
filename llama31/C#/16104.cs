public class TestData\n{\n    public string Keyword { get; set; }\n    public string ProjectGuid { get; set; }\n    public string UserGuid { get; set; }\n}\n\npublic ActionResult Test(TestData data)\n{\n    string keyword = data.Keyword;\n    return new JsonResult { Data = keyword };\n}