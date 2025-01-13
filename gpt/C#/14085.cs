using System;\nusing System.Reflection;\n\npublic class EventHelper\n{\n    public static void RemoveAllEventHandlers(object target, string eventName)\n    {\n        if (target == null) throw new ArgumentNullException(nameof(target));\n        if (string.IsNullOrEmpty(eventName)) throw new ArgumentNullException(nameof(eventName));\n\n        // Get the event\n        EventInfo eventInfo = target.GetType().GetEvent(eventName, BindingFlags.Public | BindingFlags.NonPublic | BindingFlags.Instance);\n        if (eventInfo == null) throw new ArgumentException($"Event '{eventName}' not found on target of type '{target.GetType()}'.");\n\n        // Get the field that stores the event's delegate\n        FieldInfo fieldInfo = target.GetType().GetField(eventName, BindingFlags.NonPublic | BindingFlags.Instance);\n        if (fieldInfo == null) throw new ArgumentException($"Event '{eventName}' does not have a backing field.");\n\n        // Get the event's delegate (multicast delegate)\n        MulticastDelegate eventDelegate = (MulticastDelegate)fieldInfo.GetValue(target);\n        if (eventDelegate == null) return;\n\n        // Get the invocation list (list of subscribed event handlers)\n        Delegate[] delegates = eventDelegate.GetInvocationList();\n\n        // Unsubscribe each handler\n        foreach (var handler in delegates)\n        {\n            eventInfo.RemoveEventHandler(target, handler);\n        }\n    }\n}