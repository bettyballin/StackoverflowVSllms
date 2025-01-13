public class Product\n{\n    public virtual int Id { get; set; }\n    public virtual string Sku { get; set; }\n\n    // Non-localized properties\n\n    public virtual IList<ProductTranslation> Translations { get; protected set; }\n\n    public virtual string Name\n    {\n        get => GetLocalized(x => x.Name);\n        set => SetLocalized(x => x.Name, value);\n    }\n\n    public virtual string Description\n    {\n        get => GetLocalized(x => x.Description);\n        set => SetLocalized(x => x.Description, value);\n    }\n\n    private T GetLocalized<T>(Func<ProductTranslation, T> selector)\n    {\n        var culture = Thread.CurrentThread.CurrentUICulture.Name;\n        return Translations.FirstOrDefault(t => t.LanguageCode == culture)?.Name ?? Translations.FirstOrDefault(t => t.IsDefault)?.Name;\n    }\n\n    private void SetLocalized<T>(Expression<Func<ProductTranslation, T>> expression, T value)\n    {\n        var expressionBody = (MemberExpression)expression.Body;\n        var propertyInfo = (PropertyInfo)expressionBody.Member;\n\n        var culture = Thread.CurrentThread.CurrentUICulture.Name;\n        var translation = Translations.FirstOrDefault(t => t.LanguageCode == culture);\n\n        if (translation != null)\n        {\n            propertyInfo.SetValue(translation, value);\n        }\n        else\n        {\n            var newTranslation = new ProductTranslation { LanguageCode = culture };\n            Translations.Add(newTranslation);\n            propertyInfo.SetValue(newTranslation, value);\n        }\n    }\n\n    public Product()\n    {\n        Translations = new List<ProductTranslation>();\n    }\n}\n\npublic class ProductTranslation\n{\n    public virtual int Id { get; set; }\n    public virtual Product Product { get; set; }\n    public virtual string LanguageCode { get; set; }\n    public virtual bool IsDefault { get; set; } // Set the default language translation to true if needed\n\n    public virtual string Name { get; set; }\n    public virtual string Description { get; set; }\n\n    public ProductTranslation()\n    {\n        IsDefault = false;\n    }\n}