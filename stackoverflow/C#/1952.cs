/// <summary>\n    /// There are no comments for Client in the schema.\n    /// </summary>\n    public global::System.Data.Objects.ObjectQuery<Client> Client\n    {\n        get\n        {\n            if ((this._Client== null))\n            {\n                this._Client = base.CreateQuery<Client>("[Client]");\n            }\n            return this._Client;\n        }\n    }\n    private global::System.Data.Objects.ObjectQuery<Client> _Client;