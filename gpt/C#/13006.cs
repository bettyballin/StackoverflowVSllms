using System;\nusing System.IdentityModel.Tokens.Jwt;\nusing System.Security.Claims;\nusing Microsoft.IdentityModel.Tokens;\n\npublic string GenerateJwtToken(string username)\n{\n    var securityKey = new SymmetricSecurityKey(System.Text.Encoding.UTF8.GetBytes("YourSecretKeyHere"));\n    var credentials = new SigningCredentials(securityKey, SecurityAlgorithms.HmacSha256);\n\n    var claims = new[]\n    {\n        new Claim(JwtRegisteredClaimNames.Sub, username),\n        new Claim(JwtRegisteredClaimNames.Jti, Guid.NewGuid().ToString())\n    };\n\n    var token = new JwtSecurityToken(\n        issuer: "yourIssuer",\n        audience: "yourAudience",\n        claims: claims,\n        expires: DateTime.Now.AddMinutes(30),\n        signingCredentials: credentials);\n\n    return new JwtSecurityTokenHandler().WriteToken(token);\n}