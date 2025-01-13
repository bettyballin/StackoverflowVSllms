using System;\nusing System.Net;\n\npublic partial class UserDefinedFunctions\n{\n    [SqlProcedure]\n    public static SqlString ResolveHostname(SqlString hostname)\n    {\n        IPHostEntry hostEntry = Dns.GetHostEntry(hostname.Value);\n        IPAddress[] addresses = hostEntry.AddressList;\n        return addresses[0].ToString();\n    }\n}