using System;\nusing System.Reflection;\n\npublic static void RemoveEventHandlers(object target, string eventName, Delegate handler)\n{\n    // Get the type of the target object\n    Type targetType = target.GetType();\n\n    // Get the event info\n    EventInfo eventInfo = targetType.GetEvent(eventName);\n\n    // Get the field info for the event\n    FieldInfo eventFieldInfo = targetType.GetField(eventName, BindingFlags.Instance | BindingFlags.NonPublic);\n\n    // Get the current event handlers\n    Delegate currentHandlers = (Delegate)eventFieldInfo.GetValue(target);\n\n    // Remove the specified handler\n    currentHandlers = Delegate.Remove(currentHandlers, handler);\n\n    // Set the new event handlers\n    eventFieldInfo.SetValue(target, currentHandlers);\n}