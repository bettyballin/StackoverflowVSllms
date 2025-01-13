var builder = WebApplication.CreateBuilder(args);\n\n// Add services to the container.\nbuilder.Services.AddControllers();\n\nvar app = builder.Build();\n\n// Configure HTTP request pipeline.\n\napp.UseHttpsRedirection();\napp.UseAuthorization();\n\napp.MapControllers();\n\napp.Run();