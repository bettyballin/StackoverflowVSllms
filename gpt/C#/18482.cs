public class UserValidator : AbstractValidator<User>\n{\n    public UserValidator()\n    {\n        RuleFor(user => user.Email).EmailAddress().WithMessage("Invalid email address.");\n        RuleFor(user => user.Password).Matches(".{8,20}").WithMessage("Password must be between 8 and 20 characters.");\n    }\n}