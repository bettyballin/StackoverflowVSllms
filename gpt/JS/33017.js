// Validate for US currency format allowing whole numbers and numbers with up to 2 decimal places\njQuery.validator.addMethod("decimalTwo", function(value, element) {\n    return this.optional(element) || /^\d{1,3}(\.\d{1,2})?$/.test(value);\n}, "Must be in US currency format, e.g., 0.99 or 100");