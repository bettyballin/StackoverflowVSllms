public class Car : ISelectableItem\n{\n    public string Name { get; set; }\n    public bool IsFast { get; set; }\n    public bool IsSelected { get; set; }\n}\n\npublic class Fruit : ISelectableItem\n{\n    public string Name { get; set; }\n    public bool ILikeIt { get; set; }\n    public bool IsSelected { get; set; }\n}