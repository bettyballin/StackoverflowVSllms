public class WindowsSessionHost : ISessionHost\n{\n    private UserSession _userSession;\n\n    public UserSession UserSession\n    {\n        get { return _userSession; }\n        set { _userSession = value; }\n    }\n}