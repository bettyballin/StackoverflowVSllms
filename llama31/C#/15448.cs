public class MyBusinessService\n{\n    private readonly ISessionHost _sessionHost;\n\n    public MyBusinessService(ISessionHost sessionHost)\n    {\n        _sessionHost = sessionHost;\n    }\n\n    public void DoSomething()\n    {\n        UserSession userSession = _sessionHost.UserSession;\n        // Use userSession as needed\n    }\n}