using System;\n\npublic class CRC_B\n{\n    public static ushort CalculateCRC_B(byte[] data)\n    {\n        ushort crc = 0xFFFF;\n\n        foreach (byte b in data)\n        {\n            crc ^= (ushort)(b << 8);\n            for (int i = 0; i < 8; i++)\n            {\n                if ((crc & 0x8000) != 0)\n                {\n                    crc = (ushort)((crc << 1) ^ 0x1021);\n                }\n                else\n                {\n                    crc <<= 1;\n                }\n            }\n        }\n\n        return crc;\n    }\n\n    public static void Main(string[] args)\n    {\n        byte[] example1 = { 0x00, 0x00, 0x00 };\n        ushort crc1 = CalculateCRC_B(example1);\n        Console.WriteLine($"CRC_B for 0x00 0x00 0x00: 0x{crc1:X4}");\n\n        byte[] example2 = { 0x0F, 0xAA, 0xFF };\n        ushort crc2 = CalculateCRC_B(example2);\n        Console.WriteLine($"CRC_B for 0x0F 0xAA 0xFF: 0x{crc2:X4}");\n    }\n}