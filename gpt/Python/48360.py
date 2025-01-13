def evaluate_condition(variable_values, condition):\n    if condition["type"] == "AND":\n        return all(evaluate_condition(variable_values, sub_cond) for sub_cond in condition["conditions"])\n    elif condition["type"] == "OR":\n        return any(evaluate_condition(variable_values, sub_cond) for sub_cond in condition["conditions"])\n    else:\n        variable = condition["variable"]\n        operator = condition["operator"]\n        value = condition["value"]\n\n        if operator == "==":\n            return variable_values.get(variable) == value\n        elif operator == "!=":\n            return variable_values.get(variable) != value\n        elif operator == ">":\n            return variable_values.get(variable) > value\n        elif operator == "<":\n            return variable_values.get(variable) < value\n        elif operator == ">=":\n            return variable_values.get(variable) >= value\n        elif operator == "<=":\n            return variable_values.get(variable) <= value\n        else:\n            raise ValueError(f"Unknown operator: {operator}")\n\n# Example use\nvariable_values = {\n    "var1": True,\n    "var2": False,\n    "var3": 10,\n    "var4": 30\n}\n\ncondition = {\n    "type": "AND",\n    "conditions": [\n        {"variable": "var1", "operator": "==", "value": True},\n        {"variable": "var2", "operator": "==", "value": False}\n    ]\n}\n\nresult = evaluate_condition(variable_values, condition)\nprint(result)  # Output: True