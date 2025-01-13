public class ProductCategory : IEquatable<ProductCategory>\n{\n    public virtual int Id { get; set; }\n    // other fields...\n\n    public override bool Equals(object obj)\n    {\n        return Equals(obj as ProductCategory);\n    }\n\n    public virtual bool Equals(ProductCategory other)\n    {\n        if (other == null) return false;\n        if (ReferenceEquals(this, other)) return true;\n\n        return Id == other.Id;\n    }\n\n    public override int GetHashCode()\n    {\n        unchecked // Overflow is fine\n        {\n            int hash = 17;\n            hash = hash * 23 + Id.GetHashCode();\n            \n            // Add more fields if necessary\n            return hash;\n        }\n    }\n}