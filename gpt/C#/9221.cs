using System.ServiceModel;\nusing MyWcfApplication.Common.Models;\n\nnamespace MyWcfApplication.Common.Contracts\n{\n    [ServiceContract]\n    public interface IOrderService\n    {\n        [OperationContract]\n        Order GetOrder(int orderId);\n    }\n}