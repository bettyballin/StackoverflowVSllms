public interface IIdentifiableEntity\n{\n    int Id { get; }\n}\n\npublic class News : IIdentifiableEntity\n{\n    public int NewsId { get; set; } // Assuming NewsId is the primary key\n    public string Title { get; set; }\n    public string Article { get; set; }\n\n    public int Id => NewsId;\n}