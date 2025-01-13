using NHibernate.SqlTypes;\nusing NHibernate.UserTypes;\nusing System.Data;\n\npublic class LanguageUserType : IUserType\n{\n    public object NullSafeGet(IDataReader rs, string[] names, object owner)\n    {\n        var obj = NHibernateUtil.String.NullSafeGet(rs, names[0]);\n        if (obj == null) return null;\n        \n        return Enum.Parse(typeof(LanguageEnum), (string)obj);\n    }\n\n    public void NullSafeSet(IDbCommand cmd, object value, int index)\n    {\n        string stringValue = value != null ? ((LanguageEnum)value).ToString() : null;\n        NHibernateUtil.String.NullSafeSet(cmd, stringValue, index);\n    }\n\n    // Implement Equals and GetHashCode methods\n\n    public new bool Equals(object x, object y) => x?.Equals(y) ?? y == null;\n\n    public int GetHashCode(object x)\n    {\n        return x.GetHashCode();\n    }\n\n    // Other IUserType members (Name, ReturnedType, DeepCopy, Replace, Assemble, Disassemble)\n    public Type ReturnedType => typeof(LanguageEnum);\n    public SqlType[] SqlTypes => new[]{ NHibernateUtil.String.SqlType };\n    public object DeepCopy(object value) => value;\n    public object Replace(object original, object target, object owner) => original;\n    public object Assemble(object cached, object owner) => cached;\n    public object Disassemble(object value) => value;\n\n    public bool IsMutable => false;\n}