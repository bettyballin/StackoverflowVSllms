public class YourEntity\n{\n    public int Id { get; set; }\n    public string Name { get; set; }\n\n    // Add this rowversion field for optimistic concurrency\n    [Timestamp]\n    public byte[] RowVersion { get; set; }\n}