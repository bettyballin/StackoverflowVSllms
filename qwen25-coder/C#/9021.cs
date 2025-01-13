using System;\nusing System.Web.Services;\nusing Newtonsoft.Json; // Ensure you have Newtonsoft.Json installed\n\n[WebService(Namespace = "http://tempuri.org/")]\n[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]\n[System.ComponentModel.ToolboxItem(false)]\n[System.Web.Script.Services.ScriptService]\npublic class BasketServices : System.Web.Services.WebService\n{\n    [WebMethod(true)]\n    public string AddItemToBasket(string json)\n    {\n        // Parse the JSON string into a .NET object (ensure you have a class that matches your JSON structure)\n        var itemData = JsonConvert.DeserializeObject<ItemData>(json);\n        \n        // Do whatever you need to do with itemData\n        return "Success"; // or any other response\n    }\n}\n\n// Define a class that matches the JSON structure\npublic class ItemData\n{\n    public string name { get; set; }\n    public string surname { get; set; }\n}