using System;\nusing System.Security.Cryptography;\nusing System.Text;\n\npublic class Md5Crypt\n{\n    private const string _crypt_a64 = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";\n\n    public static string Md5Crypt(string password, string salt)\n    {\n        byte[] passwordBytes = Encoding.UTF8.GetBytes(password);\n        byte[] saltBytes = Encoding.UTF8.GetBytes(salt);\n\n        // refine the salt\n        int sp = 0;\n        if (saltBytes[0] == '$' && saltBytes[1] == '1' && saltBytes[2] == '$')\n            sp += 3;\n\n        int ep = sp;\n        while (ep < saltBytes.Length && saltBytes[ep] != '$' && ep < sp + 8)\n            ep++;\n\n        int sl = ep - sp;\n\n        // compute the hash\n        byte[] hash = ComputeHash(passwordBytes, saltBytes, sp, sl);\n\n        // encode the hash\n        string encodedHash = EncodeHash(hash);\n\n        // construct the output string\n        string output = "$1$" + Encoding.UTF8.GetString(saltBytes, sp, sl) + "$" + encodedHash;\n\n        return output;\n    }\n\n    private static byte[] ComputeHash(byte[] passwordBytes, byte[] saltBytes, int sp, int sl)\n    {\n        using (MD5 md5 = MD5.Create())\n        {\n            // compute the initial hash\n            byte[] initialHash = md5.ComputeHash(Combine(passwordBytes, saltBytes, sp, sl));\n\n            // compute the final hash\n            byte[] finalHash = md5.ComputeHash(Combine(initialHash, passwordBytes, saltBytes, sp, sl));\n\n            // iterate 1000 times\n            for (int i = 0; i < 1000; i++)\n            {\n                byte[] input = i % 2 == 0 ? passwordBytes : finalHash;\n                byte[] output = md5.ComputeHash(Combine(input, saltBytes, sp, sl));\n                finalHash = output;\n            }\n\n            return finalHash;\n        }\n    }\n\n    private static byte[] Combine(byte[] passwordBytes, byte[] saltBytes, int sp, int sl)\n    {\n        byte[] combined = new byte[passwordBytes.Length + saltBytes.Length];\n        Array.Copy(passwordBytes, 0, combined, 0, passwordBytes.Length);\n        Array.Copy(saltBytes, sp, combined, passwordBytes.Length, sl);\n        return combined;\n    }\n\n    private static string EncodeHash(byte[] hash)\n    {\n        ulong l = (((ulong)hash[0]) << 16) | (((ulong)hash[6]) << 8) | ((ulong)hash[12]);\n        string encodedHash = _crypt_to64(l, 4);\n\n        l = (((ulong)hash[1]) << 16) | (((ulong)hash[7]) << 8) | ((ulong)hash[13]);\n        encodedHash += _crypt_to64(l, 4);\n\n        l = (((ulong)hash[2]) << 16) | (((ulong)hash[8]) << 8) | ((ulong)hash[14]);\n        encodedHash += _crypt_to64(l, 4);\n\n        l = (((ulong)hash[3]) << 16) | (((ulong)hash[9]) << 8) | ((ulong)hash[15]);\n        encodedHash += _crypt_to64(l, 4);\n\n        l = (((ulong)hash[4]) << 16) | (((ulong)hash[10]) << 8) | ((ulong)hash[5]);\n        encodedHash += _crypt_to64(l, 4);\n\n        l = (ulong)hash[11];\n        encodedHash += _crypt_to64(l, 2);\n\n        return encodedHash;\n    }\n\n    private static string _crypt_to64(ulong v, int n)\n    {\n        string result = "";\n        while (--n >= 0)\n        {\n            result += _crypt_a64[(int)(v & 0x3f)];\n            v >>= 6;\n        }\n        return result;\n    }\n}