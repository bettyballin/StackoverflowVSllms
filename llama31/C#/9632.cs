amespace YourSilverlightApp.SharedProxies\n{\n    [DataContract]\n    public class Person\n    {\n        [DataMember]\n        public string FirstName { get; set; }\n        [DataMember]\n        public string LastName { get; set; }\n        [DataMember]\n        public string PrivateData { get; set; }\n    }\n}