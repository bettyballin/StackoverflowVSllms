// Using Newtonsoft.Json for JSON serialization/deserialization\n    string jsonString = JsonConvert.SerializeObject(myDataInstance);\n    var myDataInstance = JsonConvert.DeserializeObject<MyData>(jsonString);