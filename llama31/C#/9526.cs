public class UserValidator : AbstractValidator<User>\n{\n    public UserValidator()\n    {\n        RuleFor(x => x.Name).NotEmpty().WithMessage("Name is required");\n        RuleFor(x => x.Email).EmailAddress().WithMessage("Invalid email address");\n    }\n}