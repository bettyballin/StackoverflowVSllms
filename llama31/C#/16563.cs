public static void Main(String[] args)\n{\n    Console.WriteLine("Mutex Sample ...");\n    // Create Mutex initialOwned, with name of "MyMutex".\n    gM1 = new Mutex(true, "MyMutex");\n    // Create Mutex initialOwned, with no name.\n    gM2 = new Mutex(true);\n\n    gM1.ReleaseMutex(); // Release the mutex before starting other threads\n    gM2.ReleaseMutex(); // Release the mutex before starting other threads\n\n    // ... rest of your code\n}