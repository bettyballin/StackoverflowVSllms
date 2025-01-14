from System.ComponentModel.Composition import Export, ContractType\n\n@Export(ContractType(IScript))\nclass MyScript(IScript):\n    def Execute(self):\n        print("Hello from IronPython!")