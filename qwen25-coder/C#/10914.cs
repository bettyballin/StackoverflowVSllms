[DataContract]\n   public class MyData\n   {\n       [DataMember(IsRequired = false)]\n       public string MyProperty { get; set; }\n\n       [DataMember]\n       public bool MyPropertySpecified { get; set; }\n   }