[ServiceContract]\npublic interface IBookService\n{\n    [OperationContract]\n    [WebGet(UriTemplate = "/books")]\n    List<Book> GetBooks();\n\n    [OperationContract]\n    [WebGet(UriTemplate = "/books/{id}")]\n    Book GetBookById(string id);\n}\n\n[ServiceContract]\npublic interface IAuthorService\n{\n    [OperationContract]\n    [WebGet(UriTemplate = "/authors")]\n    List<Author> GetAuthors();\n\n    [OperationContract]\n    [WebGet(UriTemplate = "/authors/{id}")]\n    Author GetAuthorById(string id);\n}\n\n[ServiceContract]\npublic interface IPublisherService\n{\n    [OperationContract]\n    [WebGet(UriTemplate = "/publishers")]\n    List<Publisher> GetPublishers();\n\n    [OperationContract]\n    [WebGet(UriTemplate = "/publishers/{id}")]\n    Publisher GetPublisherById(string id);\n}