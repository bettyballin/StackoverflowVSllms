using System.Net;\n\npublic static (long, long) ParseIPv6Address(string address)\n{\n    var ipAddress = IPAddress.Parse(address);\n    var bytes = ipAddress.GetAddressBytes();\n    var high = BitConverter.ToInt64(bytes, 0);\n    var low = BitConverter.ToInt64(bytes, 8);\n    return (high, low);\n}