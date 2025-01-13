[Flags]\npublic enum CheckType\n{\n    Form = 1,\n    QueryString = 2,\n    TempData = 4,\n}\n\npublic void ExecuteActionsBasedOnCheckType(CheckType theCheckType)\n{\n    // Loop through all possible values of the enum.\n    foreach (CheckType check in Enum.GetValues(typeof(CheckType)))\n    {\n        // Check if the current flag is set in the provided value.\n        if ((theCheckType & check) == check && check != 0)\n        {\n            switch (check)\n            {\n                case CheckType.Form:\n                    DoSomething(); // Perform action for Form\n                    break;\n\n                case CheckType.QueryString:\n                    DoSomethingElse(); // Perform action for QueryString\n                    break;\n\n                case CheckType.TempData:\n                    DoWhatever(); // Perform action for TempData\n                    break;\n            }\n        }\n    }\n}\n\npublic void DoSomething()\n{\n    // Implementation here\n}\n\npublic void DoSomethingElse()\n{\n    // Implementation here\n}\n\npublic void DoWhatever()\n{\n    // Implementation here\n}