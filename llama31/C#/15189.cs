// In your WCF service\n[ServiceContract]\npublic interface IYourComControlService\n{\n    [OperationContract]\n    void SetParameters(string param1, string param2);\n\n    [OperationContract]\n    void Authenticate();\n}\n\n// In your Silverlight code\nYourComControlServiceClient client = new YourComControlServiceClient();\nclient.SetParametersAsync(param1, param2);\nclient.AuthenticateAsync();