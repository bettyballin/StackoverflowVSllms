using NHibernate;\n   using NHibernate.SqlTypes;\n   using NHibernate.UserTypes;\n   using System;\n   using System.Data;\n   using System.Text;\n\n   public class FixedLengthStringType : IUserType\n   {\n       public SqlType[] SqlTypes => new SqlType[] { new SqlType(DbType.StringFixedLength, 6) };\n\n       public Type ReturnedType => typeof(string);\n\n       public bool IsMutable => false;\n\n       public object NullSafeGet(IDataReader rs, string[] names, object owner)\n       {\n           var value = NHibernateUtil.String.NullSafeGet(rs, names[0]) as string;\n           return value?.TrimEnd();\n       }\n\n       public void NullSafeSet(IDbCommand cmd, object value, int index)\n       {\n           var parameter = (IDbDataParameter)cmd.Parameters[index];\n           if (value == null)\n           {\n               parameter.Value = DBNull.Value;\n           }\n           else\n           {\n               parameter.Value = ((string)value).PadRight(6);\n           }\n       }\n\n       public object DeepCopy(object value)\n       {\n           return value;\n       }\n\n       public object Assemble(object cached, object owner)\n       {\n           return cached;\n       }\n\n       public object Disassemble(object value)\n       {\n           return value;\n       }\n\n       public object Replace(object original, object target, object owner)\n       {\n           return original;\n       }\n\n       public bool Equals(object x, object y)\n       {\n           return object.Equals(x, y);\n       }\n\n       public int GetHashCode(object x)\n       {\n           return x?.GetHashCode() ?? 0;\n       }\n   }