using System.ComponentModel.DataAnnotations;\n\npublic class Product {\n    public int Id { get; set; }\n\n    [Required(ErrorMessage = "Name is required")]\n    public string Name { get; set; }\n\n    [Range(1, 1000, ErrorMessage = "Price must be between 1 and 1000")]\n    public decimal Price { get; set; }\n}