public class MyRepository\n{\n    private readonly IModelConverter<MyModel, LinqToSqlModel> _converter;\n    private readonly DataContext _context;\n\n    public MyRepository(IModelConverter<MyModel, LinqToSqlModel> converter, DataContext context)\n    {\n        _converter = converter;\n        _context = context;\n    }\n\n    public IEnumerable<MyModel> GetModelsWhere(Func<MyModel, bool> predicate)\n    {\n        var linqModels = _context.GetTable<LinqToSqlModel>().Where(predicate, _converter);\n        return linqModels.Select(_converter.Convert);\n    }\n}