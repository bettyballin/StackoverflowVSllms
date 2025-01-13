public class SequenceIdGenerator : IIdentifierGenerator, IConfigurable\n   {\n       private string sequenceName;\n\n       public void Configure(IType type, IPropertiesParameterSpecification parameters, IDictionary<string, string> properties)\n       {\n           sequenceName = (string)properties[sequenceName];\n       }\n\n       public object Generate(ISessionImplementor session, object obj)\n       {\n           var sqlQuery = new SqlQuery(session.Factory)\n               .AddScalar("NextValue", NHibernate.NHibernateUtil.Int64)\n               .SetTimeout(5);\n\n           sqlQuery.Call("{call GetNextSequenceValue (?, ?)}").SetString(0, sequenceName);\n           int? nextValue = (int?)sqlQuery.UniqueResult();\n           \n           if (!nextValue.HasValue)\n           {\n               throw new Exception("Failed to get the next value from the sequence.");\n           }\n\n           return nextValue.Value;\n       }\n   }