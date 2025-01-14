# rule_engine.py\n\nfrom rules import KeywordRepetitionRule\n\nclass RuleEngine:\n    def __init__(self):\n        self.rules = []\n\n    def add_rule(self, rule):\n        self.rules.append(rule)\n\n    def apply_rules(self, data):\n        results = []\n        for rule in self.rules:\n            result = rule.apply(data)\n            if result:\n                results.append(result)\n        return results\n\n# Initialize the rule engine and add rules\nrule_engine = RuleEngine()\nrule_engine.add_rule(KeywordRepetitionRule())\n\n# Add more rules to the engine as needed