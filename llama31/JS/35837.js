ParentControl.prototype = {\n    initialize: function() {\n        this._childControl = Sys.UI.Control.get(this._childControlID);\n        this._childControl.callMethod();\n\n        ParentControl.callBaseMethod(this, 'initialize');\n    },\n    dispose: function() {\n        ParentControl.callBaseMethod(this, 'dispose');\n    }\n}