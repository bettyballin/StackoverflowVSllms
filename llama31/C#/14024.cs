using System;\nusing System.Messaging;\n\nclass MsmqMonitor\n{\n    public static void Main(string[] args)\n    {\n        string queuePath = @".\Private$\MyQueue"; // Replace with your queue path\n\n        // Create a MessageQueue object\n        MessageQueue queue = new MessageQueue(queuePath);\n\n        // Set up an event handler for the ReceiveCompleted event\n        queue.ReceiveCompleted += new ReceiveCompletedEventHandler(OnReceiveCompleted);\n\n        // Enable the event\n        queue.BeginReceive();\n\n        // Set up an event handler for the PeekCompleted event\n        queue.PeekCompleted += new PeekCompletedEventHandler(OnPeekCompleted);\n\n        // Enable the event\n        queue.BeginPeek();\n\n        Console.ReadLine(); // Keep the console app running\n    }\n\n    // Event handler for ReceiveCompleted event\n    private static void OnReceiveCompleted(object source, ReceiveCompletedEventArgs asyncResult)\n    {\n        // Get the queue from the event args\n        MessageQueue queue = (MessageQueue)source;\n\n        // Get the message from the event args\n        Message message = queue.EndReceive(asyncResult.AsyncResult);\n\n        // Process the message\n        Console.WriteLine("Message received: " + message.Body);\n\n        // Begin receiving again\n        queue.BeginReceive();\n    }\n\n    // Event handler for PeekCompleted event\n    private static void OnPeekCompleted(object source, PeekCompletedEventArgs asyncResult)\n    {\n        // Get the queue from the event args\n        MessageQueue queue = (MessageQueue)source;\n\n        // Get the message from the event args\n        Message message = queue.EndPeek(asyncResult.AsyncResult);\n\n        // Process the message\n        Console.WriteLine("Message peeked: " + message.Body);\n\n        // Begin peeking again\n        queue.BeginPeek();\n    }\n}