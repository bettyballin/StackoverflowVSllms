[MetadataType(typeof(CustomerMetadata))]\npublic partial class Customer\n{\n}\n\npublic class CustomerMetadata\n{\n    [Required]\n    [StringLength(50)]\n    public string Name { get; set; }\n}