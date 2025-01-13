public class ShipmentRequest {\n    public ShipmentRequestId Id { get; } = new ShipmentRequestId(Guid.NewGuid());\n    // ...\n}\n\npublic class ShipmentRequestId {\n    public Guid Value { get; }\n\n    public ShipmentRequestId(Guid value) => Value = value;\n}