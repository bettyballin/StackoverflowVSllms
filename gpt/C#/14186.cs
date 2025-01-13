public class YourService : IYourService\n    {\n        public string YourOperation()\n        {\n            var identity = (ClaimsIdentity)Thread.CurrentPrincipal.Identity;\n            var nameClaim = identity.FindFirst(ClaimTypes.Name);\n            string userName = nameClaim?.Value;\n            // Use the claims as needed\n            return $"Hello, {userName}";\n        }\n    }