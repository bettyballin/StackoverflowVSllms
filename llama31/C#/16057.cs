public class MyModel\n{\n    [DisplayName("I agree to the terms and conditions")]\n    [Range(typeof(bool), "true", "true", ErrorMessage = "You must agree to the terms and conditions")]\n    public bool AgreeToTerms { get; set; }\n}