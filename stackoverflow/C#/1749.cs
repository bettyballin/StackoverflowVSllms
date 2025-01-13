// This class implements a simple customer type \n// that implements the IPropertyChange interface.\npublic class DemoCustomer : INotifyPropertyChanged\n{\n    // These fields hold the values for the public properties.\n    private Guid idValue = Guid.NewGuid();\n    private string customerName = String.Empty;\n    private string companyNameValue = String.Empty;\n    private string phoneNumberValue = String.Empty;\n\n    public event PropertyChangedEventHandler PropertyChanged;\n\n    private void NotifyPropertyChanged(String info)\n    {\n        if (PropertyChanged != null)\n        {\n            PropertyChanged(this, new PropertyChangedEventArgs(info));\n        }\n    }\n\n    // The constructor is private to enforce the factory pattern.\n    private DemoCustomer()\n    {\n        customerName = "no data";\n        companyNameValue = "no data";\n        phoneNumberValue = "no data";\n    }\n\n    // This is the public factory method.\n    public static DemoCustomer CreateNewCustomer()\n    {\n        return new DemoCustomer();\n    }\n\n    // This property represents an ID, suitable\n    // for use as a primary key in a database.\n    public Guid ID\n    {\n        get\n        {\n            return this.idValue;\n        }\n    }\n\n    public string CompanyName\n    {\n        get {return this.companyNameValue;}\n\n        set\n        {\n            if (value != this.companyNameValue)\n            {\n                this.companyNameValue = value;\n                NotifyPropertyChanged("CompanyName");\n            }\n        }\n    }\n    public string PhoneNumber\n    {\n        get { return this.phoneNumberValue; }\n\n        set \n        {\n            if (value != this.phoneNumberValue)\n            {\n                this.phoneNumberValue = value;\n                NotifyPropertyChanged("PhoneNumber");\n            }\n        }\n    }\n}