enum Endianness { LittleEndian, BigEndian }\n\nclass EndianBinaryReader : BinaryReader\n{\n    private Endianness _endianness;\n\n    public EndianBinaryReader(Stream stream, Endianness endianness) : base(stream)\n    {\n        _endianness = endianness;\n    }\n\n    public override int ReadInt32()\n    {\n        byte[] bytes = ReadBytes(4);\n        if (_endianness == Endianness.BigEndian && BitConverter.IsLittleEndian)\n        {\n            Array.Reverse(bytes);\n        }\n        return BitConverter.ToInt32(bytes, 0);\n    }\n}\n\nclass EndianBinaryWriter : BinaryWriter\n{\n    private Endianness _endianness;\n\n    public EndianBinaryWriter(Stream stream, Endianness endianness) : base(stream)\n    {\n        _endianness = endianness;\n    }\n\n    public override void Write(int value)\n    {\n        byte[] bytes = BitConverter.GetBytes(value);\n        if (_endianness == Endianness.BigEndian && BitConverter.IsLittleEndian)\n        {\n            Array.Reverse(bytes);\n        }\n        base.Write(bytes);\n    }\n}