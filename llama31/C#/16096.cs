[AttributeUsage(AttributeTargets.Method)]\npublic class MessageHandlerAttribute : Attribute\n{\n    public MessageHandlerAttribute(string s1, Type handlerType)\n    {\n        HandlerName = s1;\n        HandlerType = handlerType;\n    }\n\n    public string HandlerName { get; set; }\n    public Type HandlerType { get; set; }\n}