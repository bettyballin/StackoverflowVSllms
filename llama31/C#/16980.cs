[Authorize(Roles = "Managers")]\npublic class AccountManager\n{\n    public void AddAccount(Account account)\n    {\n        // Add the account\n    }\n}