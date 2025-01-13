' Product model class\nPublic Class Product\n    Public Property ProductID As Integer\n    Public Property Name As String\n    ' Other properties\nEnd Class\n\n' IProductRepository interface\nPublic Interface IProductRepository\n    Function GetProduct(productId As Integer) As Product\n    Function GetRelatedProducts(productId As Integer) As IList(Of Product)\n    Sub Save(product As Product)\nEnd Interface\n\n' IProductService interface\nPublic Interface IProductService\n    Function GetProduct(productId As Integer) As Product\n    Function GetRelatedProducts(productId As Integer) As IList(Of Product)\n    Sub Save(product As Product)\nEnd Interface\n\n' ProductService implementation\nPublic Class ProductService\n    Implements IProductService\n\n    Private ReadOnly _productRepository As IProductRepository\n\n    Public Sub New(productRepository As IProductRepository)\n        _productRepository = productRepository\n    End Sub\n\n    Public Function GetProduct(productId As Integer) As Product Implements IProductService.GetProduct\n        Return _productRepository.GetProduct(productId)\n    End Function\n\n    Public Function GetRelatedProducts(productId As Integer) As IList(Of Product) Implements IProductService.GetRelatedProducts\n        Return _productRepository.GetRelatedProducts(productId)\n    End Function\n\n    Public Sub Save(product As Product) Implements IProductService.Save\n        _productRepository.Save(product)\n    End Sub\nEnd Class