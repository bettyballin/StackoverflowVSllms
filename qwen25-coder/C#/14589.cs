public class UserService\n     {\n         // Other methods...\n\n         public bool ValidateLogin(string username, string password)\n         {\n             var user = _userRepository.GetUserByUsername(username);\n             if (user != null &&密码Hasher.Verify(user.Password, password))\n             {\n                 return true;\n             }\n             return false;\n         }\n     }