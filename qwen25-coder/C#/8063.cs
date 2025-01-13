using System;\nusing System.Collections.Generic;\nusing System.Linq;\n\npublic class UserAccount {\n    public int Id { get; set; }\n    public string Name { get; set; }\n    private List<FinancialTransaction> Transactions { get; } = new();\n\n    public event EventHandler<TransactionEventArgs> TransactionAdded;\n\n    public void AddTransaction(FinancialTransaction transaction) {\n        Transactions.Add(transaction);\n        OnTransactionAdded(transaction);\n    }\n\n    protected virtual void OnTransactionAdded(FinancialTransaction e) => TransactionAdded?.Invoke(this, new TransactionEventArgs(e));\n}\n\npublic class FinancialTransaction {\n    public int Id { get; set; }\n    public DateTime TransactionDate { get; set; }\n    public decimal Amount { get; set; }\n    public string Description { get; set; }\n    public string Type { get; set; } // Could be "Deposit", "Withdrawal", etc.\n}\n\npublic class TransactionEventArgs : EventArgs {\n    public FinancialTransaction Transaction { get; }\n\n    public TransactionEventArgs(FinancialTransaction transaction) => Transaction = transaction;\n}