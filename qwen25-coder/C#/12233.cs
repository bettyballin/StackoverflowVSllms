public override int GetHashCode()\n{\n    unchecked // Overflow is fine, just wrap around\n    {\n        int hash = 17;\n        // Assuming Field1 and Field2 are the fields used for equality comparisons.\n        hash = hash * 23 + (Field1?.GetHashCode() ?? 0); \n        hash = hash * 23 + (Field2?.GetHashCode() ?? 0);\n        return hash;\n    }\n}