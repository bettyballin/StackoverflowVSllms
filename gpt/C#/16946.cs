// Storing object in session\n    SerializableWrapper wrapper = new SerializableWrapper(nonSerializableObject);\n    Session["MyObject"] = wrapper;\n\n    // Retrieving object from session\n    SerializableWrapper wrapper = (SerializableWrapper)Session["MyObject"];\n    var nonSerializableObject = wrapper.WrappedObject;