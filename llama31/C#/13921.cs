using System;\n\npublic class SequentialGuid\n{\n    private static readonly DateTime _epoch = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);\n    private static readonly object _lock = new object();\n    private static uint _counter = 0;\n\n    public static Guid NewGuid()\n    {\n        lock (_lock)\n        {\n            var timestamp = (uint)(DateTime.UtcNow - _epoch).TotalSeconds;\n            var guid = new Guid(\n                (int)(timestamp << 16 | _counter),\n                (short)(timestamp >> 16),\n                (short)(_counter >> 8),\n                new byte[8]);\n            _counter++;\n            return guid;\n        }\n    }\n}