public class EnumInt32Type<TEnum> : ImmutableUserType<TEnum>\n        where TEnum : struct\n    {\n        public override object NullSafeGet(IDataReader rs, string[] names, ISessionImplementor session, object owner)\n        {\n            var value = NHibernateUtil.Int32.NullSafeGet(rs, names[0]);\n            return value == null ? default(TEnum) : (TEnum)value;\n        }\n\n        public override void NullSafeSet(IDbCommand cmd, object value, int index, ISessionImplementor session)\n        {\n            if (value == null || value.Equals(default(TEnum)))\n                NHibernateUtil.Int32.NullSafeSet(cmd, null, index);\n            else\n                NHibernateUtil.Int32.NullSafeSet(cmd, Convert.ToInt32(value), index);\n        }\n    }