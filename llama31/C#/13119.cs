public class Customer\n{\n    // ...\n    private ICollection<CustomerPreferences> _customerPreferences = new HashSet<CustomerPreferences>();\n\n    public ICollection<CustomerPreferences> CustomerPreferences\n    {\n        get { return _customerPreferences; }\n        set { _customerPreferences = value; }\n    }\n    // ...\n}