public class ProductService : IProductService\n{\n    private readonly IMapper _mapper;\n\n    public ProductService(IMapper mapper)\n    {\n        _mapper = mapper ?? throw new ArgumentNullException(nameof(mapper));\n    }\n\n    public ProductDTO GetProductById(int productId)\n    {\n        var product = FetchProductFromDatabase(productId);\n        return _mapper.Map<ProductDTO>(product);\n    }\n}