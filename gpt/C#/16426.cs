using FluentValidation;\n\n     public class UserModelValidator : AbstractValidator<UserModel>\n     {\n         public UserModelValidator()\n         {\n             RuleFor(user => user.Name)\n                 .NotEmpty().WithMessage("Name is required")\n                 .Length(1, 50).WithMessage("Name cannot be longer than 50 characters");\n\n             RuleFor(user => user.Age)\n                 .InclusiveBetween(18, 65).WithMessage("Age must be between 18 and 65");\n         }\n     }