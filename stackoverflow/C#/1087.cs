Dictionary<object, object> list = new Dictionary<object, object>();\nforeach (object o in enumerable)\n    if (!list.ContainsKey(o))\n    {\n        // Do the actual work.\n        list[o] = null;\n    }