public partial class User\n{\n    [DataType(DataType.EmailAddress, ErrorMessage = "Please enter an email address")]\n    public string EmailForValidation \n    { \n        get => Email; \n        set => Email = value; \n    }\n\n    // Other methods and properties...\n}