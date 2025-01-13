using System;\nusing SharpDisasm;\nusing SharpDisasm.Udis86;\n\nclass Program\n{\n    static void Main()\n    {\n        // Example x86 machine code (in bytes)\n        byte[] code = new byte[] { 0xB8, 0x04, 0x00, 0x00, 0x00, 0xBB, 0x01, 0x00, 0x00, 0x00 };\n\n        // Create a new disassembler for 32-bit x86 code\n        var disasm = new Disassembler(code, ArchitectureMode.x86_32);\n\n        // Disassemble the code\n        foreach (var instruction in disasm.Disassemble())\n        {\n            Console.WriteLine($"{instruction.Offset:X} {instruction.Mnemonic} {instruction.Operands}");\n        }\n    }\n}