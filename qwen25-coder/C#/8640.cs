using System.IdentityModel.Tokens.Jwt;\n\nstring tokenString = "your.jwt.token.here";\nvar handler = new JwtSecurityTokenHandler();\nvar jsonToken = handler.ReadJwtToken(tokenString);\n\nif (jsonToken.ValidTo > DateTime.UtcNow)\n{\n    // Token is valid, proceed to use the claims\n    string userId = jsonToken.Claims.First(c => c.Type == "sub").Value;\n}\nelse\n{\n    // Handle token expiration\n}\n\n// Validate issuer and other necessary checks