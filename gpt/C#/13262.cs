using System;\nusing System.Collections.Generic;\nusing System.DirectoryServices;\nusing System.Net.Http;\nusing System.Threading.Tasks;\n\nnamespace SendSmsToAdUsers\n{\n    class Program\n    {\n        static async Task Main(string[] args)\n        {\n            try\n            {\n                var users = GetAdUsersWithMobileNumbers("LDAP://YourDomainController");\n                foreach (var user in users)\n                {\n                    await SendSms(user.MobileNumber, "Your SMS message");\n                }\n            }\n            catch (Exception ex)\n            {\n                Console.WriteLine($"Error: {ex.Message}");\n            }\n        }\n\n        static List<AdUser> GetAdUsersWithMobileNumbers(string ldapPath)\n        {\n            var users = new List<AdUser>();\n            using (var entry = new DirectoryEntry(ldapPath))\n            using (var searcher = new DirectorySearcher(entry))\n            {\n                searcher.Filter = "(&(objectClass=user)(mobile=*))";\n                searcher.PropertiesToLoad.Add("mobile");\n                searcher.PropertiesToLoad.Add("displayName");\n\n                foreach (SearchResult result in searcher.FindAll())\n                {\n                    var mobile = result.Properties["mobile"][0]?.ToString();\n                    var displayName = result.Properties["displayName"][0]?.ToString();\n                    \n                    if (!string.IsNullOrEmpty(mobile))\n                    {\n                        users.Add(new AdUser\n                        {\n                            DisplayName = displayName,\n                            MobileNumber = mobile\n                        });\n                    }\n                }\n            }\n            return users;\n        }\n\n        static async Task SendSms(string mobileNumber, string message)\n        {\n            var smsGatewayUrl = "https://api.your-sms-gateway.com/send";\n            var apiKey = "YOUR_SMS_GATEWAY_API_KEY"; \n\n            using (var client = new HttpClient())\n            {\n                var content = new FormUrlEncodedContent(new[]\n                {\n                    new KeyValuePair<string, string>("apiKey", apiKey),\n                    new KeyValuePair<string, string>("to", mobileNumber),\n                    new KeyValuePair<string, string>("message", message)\n                });\n\n                var response = await client.PostAsync(smsGatewayUrl, content);\n                response.EnsureSuccessStatusCode();\n\n                Console.WriteLine($"Message sent to {mobileNumber}");\n            }\n        }\n    }\n\n    class AdUser\n    {\n        public string DisplayName { get; set; }\n        public string MobileNumber { get; set; }\n    }\n}