public class MyModel\n{\n    private readonly IUserInputProvider _userInputProvider;\n\n    public MyModel(IUserInputProvider userInputProvider)\n    {\n        _userInputProvider = userInputProvider;\n    }\n\n    public void HandleMessage(Message msg)\n    {\n        string reply;\n        if (msg.type == 1)\n        {\n            reply = ...;\n        }\n        else\n        {\n            string question = msg...;\n            reply = _userInputProvider.GetUserInput(question);\n        }\n        sender.Send(reply);\n    }\n}