// If you use Strongly Typed Resource Classes\nusing ProjectName.Properties; // Adjust namespace as per your project\n\nstring loginMessage = Resources.Messages.LoginSuccess;\n// Or with ResourceManager if not using strongly-typed classes\nusing System.Resources;\n\nResourceManager rm = new ResourceManager("ProjectName.Properties.Messages", typeof(Program).Assembly);\nstring loginMessage = rm.GetString("LoginSuccess");