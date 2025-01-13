// Example of NHibernate mapping\npublic class User\n{\n    public virtual int Id { get; set; }\n    public virtual string Name { get; set; }\n}\n\n// XML mapping file\n<hibernate-mapping xmlns="urn:nhibernate-mapping-2.2">\n  <class name="User">\n    <id name="Id" column="id" />\n    <property name="Name" column="name" />\n  </class>\n</hibernate-mapping>