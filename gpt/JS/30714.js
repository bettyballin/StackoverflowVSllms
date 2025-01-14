Object.extend(Function.prototype, {\n  TryCatchWrap: function() {\n    var __method = this;\n    return function() {\n      try {\n        return __method.apply(this, arguments);\n      } catch (ex) {\n        ErrorHandler.Exception(ex);\n      }\n    }\n  }\n});