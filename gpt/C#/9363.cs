// WCF Service Interface\n[ServiceContract]\npublic interface IProductService\n{\n    [OperationContract]\n    PagedResult<Product> GetProducts(int pageNumber, int pageSize);\n\n    [OperationContract]\n    ProductDetail GetProductDetail(int productId);\n}\n\n// PagedResult class to hold paged data\npublic class PagedResult<T>\n{\n    public List<T> Items { get; set; }\n    public int TotalCount { get; set; }\n}\n\n// Product and ProductDetail classes\npublic class Product\n{\n    public int Id { get; set; }\n    public string Name { get; set; }\n    // Other product properties\n}\n\npublic class ProductDetail\n{\n    public int ProductId { get; set; }\n    public string Detail { get; set; }\n    // Other detail properties\n}