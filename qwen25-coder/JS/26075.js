// Assuming MongoDB schema example\n   const entitySchema = new mongoose.Schema({\n     name: String,\n     dynamicFields: {\n       type: Map,\n       of: String // Can be altered to use other types as needed\n     }\n   });