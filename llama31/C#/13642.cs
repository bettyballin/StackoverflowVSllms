var serializer = new XmlSerializer(typeof(ResponseBase));\nvar response = (ResponseBase)serializer.Deserialize(responseStream);\n\nif (response is ActualResponse actualResponse)\n{\n    // process actual response\n}\nelse if (response is ErrorResponse errorResponse)\n{\n    // process error response\n}