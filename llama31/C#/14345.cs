[ValidateRequestMode(RequestValidationMode.Enabled)]\npublic class MyWebService : WebService\n{\n    [WebMethod]\n    public void DeleteSomething(int id)\n    {\n        // delete logic here\n    }\n}