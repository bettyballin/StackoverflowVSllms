using System;\nusing System.Collections.Generic;\nusing System.Linq;\n\npublic interface IMyBusinessObjectBase { }\n\npublic interface IBankAccount : IMyBusinessObjectBase\n{\n    IBank Bank { get; set; }\n    IBankAccountType BankAccountType { get; set; }\n    string AccountName { get; set; }\n    string AccountNumber { get; set; }\n    DateTime EffectiveDate { get; set; }\n}\n\npublic interface IBank { }\npublic interface IBankAccountType { }\n\npublic class BankAccount : IBankAccount\n{\n    public IBank Bank { get; set; }\n    public IBankAccountType BankAccountType { get; set; }\n    public string AccountName { get; set; }\n    public string AccountNumber { get; set; }\n    public DateTime EffectiveDate { get; set; }\n}\n\npublic class DuplicateValidationRule<T> where T : IMyBusinessObjectBase\n{\n    public bool Validate(ICollection<T> collection, params Func<T, object>[] keySelectors)\n    {\n        var uniqueKeys = new HashSet<string>();\n        foreach (var item in collection)\n        {\n            var key = string.Join(";", keySelectors.Select(selector => selector(item)?.ToString()));\n            if (!uniqueKeys.Add(key))\n            {\n                return false; // Duplicate found\n            }\n        }\n        return true; // No duplicates\n    }\n}\n\npublic class Program\n{\n    public static void Main()\n    {\n        IBankAccount acc1 = new BankAccount { AccountName = "Account1", AccountNumber = "123456", Bank = new Bank() };\n        IBankAccount acc2 = new BankAccount { AccountName = "Account2", AccountNumber = "654321", Bank = new Bank() };\n        IBankAccount acc3 = new BankAccount { AccountName = "Account3", AccountNumber = "123456", Bank = new Bank() };\n        IBankAccount acc4 = new BankAccount { AccountName = "Account3", AccountNumber = "123456", Bank = acc1.Bank };\n\n        ICollection<IBankAccount> bankAccounts = new List<IBankAccount> { acc1, acc2, acc3, acc4 };\n\n        var duplicateValidationRule = new DuplicateValidationRule<IBankAccount>();\n        bool isValid = duplicateValidationRule.Validate(bankAccounts, x => x.AccountNumber, x => x.Bank);\n\n        Console.WriteLine("Is the collection valid? " + isValid);\n    }\n}\n\npublic class Bank : IBank { }\npublic class BankAccountType : IBankAccountType { }