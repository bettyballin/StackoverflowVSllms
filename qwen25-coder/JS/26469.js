// Define ChildControl\nvar ChildControl = function(element) {\n    ChildControl.initializeBase(this, [element]);\n};\n\nChildControl.prototype = {\n    callMethod: function() {\n        return 'hi';\n    },\n\n    initialize: function() {\n        ChildControl.callBaseMethod(this, 'initialize');\n    },\n\n    dispose: function() {\n        ChildControl.callBaseMethod(this, 'dispose');\n    }\n};\n\n// Register the control\nif (typeof(Sys) !== 'undefined') Sys.Application.notifyScriptLoaded();\n\nChildControl.registerClass('ChildControl', AjaxControlToolkit.ScriptControl);\n\n// Define ParentControl and its methods\nvar ParentControl = function(element) {\n    ParentControl.initializeBase(this, [element]);\n};\n\nParentControl.prototype = {\n    initialize: function() {\n        // Ensure you are creating an instance of ChildControl correctly\n        this._childControlID = this.get_element().getAttribute('ChildControlID');\n        this._childControl = $find(this._childControlID); // Assuming child control is already added to the page\n\n        if (this._childControl && typeof this._childControl.callMethod === 'function') {\n            var result = this._childControl.callMethod();\n            console.log(result); // Should log 'hi'\n        } else {\n            console.error('Child method not found or child control not initialized');\n        }\n\n        ParentControl.callBaseMethod(this, 'initialize');\n    },\n\n    dispose: function() {\n        ParentControl.callBaseMethod(this, 'dispose');\n    }\n};\n\n// Register the control\nif (typeof(Sys) !== 'undefined') Sys.Application.notifyScriptLoaded();\nParentControl.registerClass('ParentControl', AjaxControlToolkit.ScriptControl);