using System.ServiceModel;\nusing CookComputing.XmlRpc;\n\n[ServiceContract(Namespace = "http://METAWEBLOGAPI.XMLRPC.COM")]\npublic interface IMetaWeblog\n{\n    [XmlRpcMethod("metaWeblog.newPost")]\n    string NewPost(string blogid, string username, string password, Post post, bool publish);\n\n    // Add other methods according to the MetaWeblog API specification\n}\n\n[XmlRpcMissingMapping(MappingAction.Ignore)]\npublic struct Post\n{\n    public DateTime dateCreated;\n    public string description;\n    public string title;\n    public int mt_allow_comments;\n    public int mt_allow_pings;\n    public int mt_convert_breaks;\n    public string[] categories;\n}