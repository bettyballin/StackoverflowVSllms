return !readOnlyFields.Contains(propertyName) &&\n       base.CanWriteProperty(propertyName);