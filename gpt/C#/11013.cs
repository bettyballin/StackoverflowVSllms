public interface IUserDataService\n   {\n       MyObject GetUserObject();\n       void SetUserObject(MyObject myObject);\n   }\n\n   public class UserDataService : IUserDataService\n   {\n       private MyObject _userObject;\n\n       public MyObject GetUserObject()\n       {\n           return _userObject;\n       }\n\n       public void SetUserObject(MyObject myObject)\n       {\n           _userObject = myObject;\n       }\n   }