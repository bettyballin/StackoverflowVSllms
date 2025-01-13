public class MyDataService : DataService<MyEntities>\n{\n    public static void InitializeService(DataServiceConfiguration config)\n    {\n        // Set rules to indicate which entity sets and service operations are visible\n        config.SetEntitySetAccessRule("*", EntitySetRights.AllRead);\n        config.SetServiceOperationAccessRule("*", ServiceOperationRights.All);\n        config.DataServiceBehavior.MaxProtocolVersion = DataServiceProtocolVersion.V3;\n    }\n}