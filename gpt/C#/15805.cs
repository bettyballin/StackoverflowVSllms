[WebService(Namespace = "http://tempuri.org/")]\n[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]\n[System.ComponentModel.ToolboxItem(false)]\n[System.Web.Script.Services.ScriptService]\npublic class BasketServices : System.Web.Services.WebService\n{\n    [WebMethod(true)]\n    public string AddItemToBasket(string name, string surname)\n    {\n        // Do stuff with name and surname\n        return myString.toJSON();\n    }\n}