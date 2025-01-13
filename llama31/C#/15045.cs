using Microsoft.Moles.Framework;\n\n// Define the dependency interface\npublic interface IMessageQueue\n{\n    void SendMessage(string message);\n}\n\n// Define the original dependency implementation\npublic class MessageQueue : IMessageQueue\n{\n    public void SendMessage(string message)\n    {\n        // implementation\n    }\n}\n\n// Create a mole for the dependency\n[Mole(typeof(MessageQueue))]\npublic class MessageQueueMole : IMessageQueue\n{\n    public void SendMessage(string message)\n    {\n        // mock implementation\n    }\n}\n\n// Use the mole in your test\n[TestMethod]\npublic void TestMessageQueue()\n{\n    // Create an instance of the mole\n    var mole = new MessageQueueMole();\n\n    // Use the mole in place of the original dependency\n    var messageQueue = mole.GetInstance();\n\n    // Call the method under test\n    messageQueue.SendMessage("Hello, world!");\n\n    // Verify the mock implementation was called\n    mole.Verify(c => c.SendMessage("Hello, world!"));\n}