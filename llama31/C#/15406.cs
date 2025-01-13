using System;\nusing System.IdentityModel.Tokens.Jwt;\nusing Microsoft.IdentityModel.Tokens;\n\n// Desktop app generates a token for the web app\nstring GenerateTokenForWebApp(string authorizationToken)\n{\n    var tokenHandler = new JwtSecurityTokenHandler();\n    var tokenDescriptor = new SecurityTokenDescriptor\n    {\n        Subject = new ClaimsIdentity(new[] { new Claim("user_id", "12345") }),\n        Expires = DateTime.UtcNow.AddMinutes(30),\n        SigningCredentials = new SigningCredentials(new SymmetricSecurityKey("secret_key"), SecurityAlgorithms.HmacSha256Signature)\n    };\n    var token = tokenHandler.CreateToken(tokenDescriptor);\n    return tokenHandler.WriteToken(token);\n}\n\n// Web app verifies the token\nbool VerifyToken(string token)\n{\n    var tokenHandler = new JwtSecurityTokenHandler();\n    try\n    {\n        var principal = tokenHandler.ValidateToken(token, new TokenValidationParameters\n        {\n            ValidateIssuer = true,\n            ValidateAudience = true,\n            ValidateLifetime = true,\n            IssuerSigningKey = new SymmetricSecurityKey("secret_key")\n        }, out var validatedToken);\n        return true;\n    }\n    catch (SecurityTokenException)\n    {\n        return false;\n    }\n}