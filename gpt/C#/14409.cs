public class Program\n{\n    public static void Main()\n    {\n        string sidString = "S-1-5-21-..."; // Replace with actual SID string\n        SecurityIdentifier sid = new SecurityIdentifier(sidString);\n        \n        string accountName = SIDConverter.GetNameFromSID(sid);\n        if (accountName != null)\n        {\n            Console.WriteLine($"Account name: {accountName}");\n        }\n        else\n        {\n            Console.WriteLine("Account name could not be found.");\n        }\n    }\n}