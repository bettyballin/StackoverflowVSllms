var hmac = new HMACSHA256(Encoding.UTF8.GetBytes(clientPassword));\nvar inputBytes = Encoding.UTF8.GetBytes($"{reqNumber}{reqText}");\nvar hashBytes = hmac.ComputeHash(inputBytes);\nvar reqChecksum = Convert.ToBase64String(hashBytes);