using System;\nusing System.IO;\n\npublic class BinaryPatch\n{\n    public static byte[] GeneratePatch(byte[] oldData, byte[] newData)\n    {\n        using (var ms = new MemoryStream())\n        {\n            var patch = new BinaryWriter(ms);\n\n            int oldPos = 0;\n            int newPos = 0;\n\n            while (newPos < newData.Length)\n            {\n                // Find a match in the old data\n                int matchLength = 0;\n                while (oldPos < oldData.Length && newPos < newData.Length && oldData[oldPos] == newData[newPos])\n                {\n                    matchLength++;\n                    oldPos++;\n                    newPos++;\n                }\n\n                // If we found a match, write a reference to the old data\n                if (matchLength > 0)\n                {\n                    patch.Write((byte)0x01); // Reference to old data\n                    patch.Write(oldPos - matchLength); // Position in old data\n                    patch.Write(matchLength); // Length of match\n                }\n\n                // If we didn't find a match, write the new data\n                else\n                {\n                    patch.Write((byte)0x00); // New data\n                    patch.Write(newData[newPos]); // New data byte\n                    newPos++;\n                }\n            }\n\n            return ms.ToArray();\n        }\n    }\n}