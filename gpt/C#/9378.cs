private List<IObjectProvider> GetProviderForType(Type type)\n{\n    List<IObjectProvider> returnValue = new List<IObjectProvider>();\n\n    foreach (KeyValuePair<Type, IObjectProvider> provider in _objectProviders)\n    {\n        if ((provider.Key.IsAssignableFrom(type) ||\n            type.IsAssignableFrom(provider.Key)) &&\n            provider.Value.SupportsType(type))\n        {\n            returnValue.Add(provider.Value);\n        }\n    }\n    return returnValue;\n}\n\nprivate IEnumerable<IObjectProvider> GetProviderForType1(Type type)\n{\n    foreach (KeyValuePair<Type, IObjectProvider> provider in _objectProviders)\n        if ((provider.Key.IsAssignableFrom(type) ||\n            type.IsAssignableFrom(provider.Key)) &&\n            provider.Value.SupportsType(type))\n\n            yield return provider.Value;             \n}