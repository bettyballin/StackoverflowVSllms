DataContainer container = invocation.InvocationTarget as DataContainer;\nif (container != null)\n{\n    invocation.ReturnValue = container.Fields[fieldName];\n}\nelse\n{\n    // handle the case where InvocationTarget is null\n}