[Serializable]\npublic class SerializableCmsEntity\n{\n    public int Id { get; set; }\n    public string Name { get; set; }\n    // Add other necessary properties\n}\n\npublic class Basket\n{\n    [NonSerialized]\n    private CMS.CmsEntity db;\n\n    private SerializableCmsEntity serializableDb;\n\n    public Basket()\n    {\n        serializableDb = new SerializableCmsEntity();\n    }\n\n    public void LoadDbData()\n    {\n        db = ...; // Load the CMS.CmsEntity object\n        serializableDb.Id = db.Id;\n        serializableDb.Name = db.Name;\n        // Copy other necessary properties\n    }\n\n    // Use the serializableDb object instead of the db object\n}