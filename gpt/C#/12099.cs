public class CentralAuthClientCredentials : ClientCredentials\n{\n    public CentralAuthClientCredentials() : base()\n    {\n    }\n\n    protected CentralAuthClientCredentials(CentralAuthClientCredentials other) : base(other)\n    {\n    }\n\n    public override SecurityTokenManager CreateSecurityTokenManager()\n    {\n        return new CustomClientCredentialsSecurityTokenManager(this);\n    }\n\n    protected override ClientCredentials CloneCore()\n    {\n        return new CentralAuthClientCredentials(this);\n    }\n}\n\n// Usage in your WCF client setup\nvar factory = new ChannelFactory<IMyService>("MyEndpointConfiguration");\n\n// Copy existing credentials\nClientCredentials defaultCredentials = factory.Endpoint.Behaviors.Find<ClientCredentials>();\nCentralAuthClientCredentials customCredentials = new CentralAuthClientCredentials(defaultCredentials);\n\n// Replace with custom credentials\nfactory.Endpoint.Behaviors.Remove<ClientCredentials>();\nfactory.Endpoint.Behaviors.Add(customCredentials);\n\nIMyService client = factory.CreateChannel();\nclient.MyServiceMethod();