export class Test {\n    private _name: string;\n\n    constructor(name: string) {\n        this._name = name;\n    }\n\n    public name2: string {\n        get() {\n            return this._name;\n        }\n    }\n}