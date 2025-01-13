public interface ICodeEntity { }\npublic interface IObjectEntity { }\npublic class Column: IObjectEntity\n{\n    public string name;\n    public System.Data.DbType type;\n}\npublic class Table: IObjectEntity\n{\n    public List<Column> columns = new List<Column>();\n    public string alias;\n}\npublic class Where : ICodeEntity { }\npublic class GroupBy : ICodeEntity { }\npublic class OrderBy : ICodeEntity { }\npublic class Select : Table, ICodeEntity\n{\n    public List<Table> joinList = new List<Table>();\n    public Where where;\n    public GroupBy groupBy;\n    public OrderBy orderBy;\n}\npublic class Condition : ICodeEntity { }\npublic class If : ICodeEntity\n{\n    public Condition condition;\n    public List<ICodeEntity> codeList = new List<ICodeEntity>();\n}