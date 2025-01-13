using SmartyStreets;\n   using SmartyStreets.USStreetApi;\n\n   public static void ValidateAddress()\n   {\n       // Client builder\n       var client = new ClientBuilder("YOUR_SMARTYSTREETS_AUTH_ID", "YOUR_SMARTYSTREETS_AUTH_TOKEN").BuildUsStreetApiClient();\n\n       // Address request\n       var lookup = new Lookup\n       {\n           Street = "1600 Amphitheatre Parkway",\n           City = "Mountain View",\n           State = "CA"\n       };\n\n       // Perform lookup\n       client.Send(lookup);\n\n       if (lookup.Result.Any())\n       {\n           var candidate = lookup.Result[0];\n           Console.WriteLine($"Address: {candidate.DeliveryLine1}, {candidate.LastLine}");\n       }\n   }