[global::System.Diagnostics.DebuggerNonUserCodeAttribute()]\npublic int? curr_reading {\n    get {\n        if (this[this.tableHistory.curr_readingColumn] is DBNull) {\n            return null;\n        } else {\n            return ((int)(this[this.tableHistory.curr_readingColumn]));\n        }\n    }\n}