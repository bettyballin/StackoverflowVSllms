[XmlType(Namespace = "http://your-namespace.com")]\npublic class Map : List<MapItem>\n{\n    public Map() { }\n}\n\n[XmlType(Namespace = "http://your-namespace.com")]\npublic class MapItem\n{\n    [XmlElement("key")]\n    public string Key { get; set; }\n\n    [XmlElement("value")]\n    public object Value { get; set; }\n}