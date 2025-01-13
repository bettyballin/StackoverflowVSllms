using System;\nusing System.Threading.Tasks;\nusing Open.Nat;\n\nclass Program\n{\n    static async Task Main()\n    {\n        var natDevice = await NatFactory.CreateNewInstanceAsync();\n        await natDevice.CreatePortMapAsync(new Mapping(Protocol.Udp, 8001, 8002));\n\n        Console.WriteLine("UPnP port mapping created successfully.");\n    }\n}