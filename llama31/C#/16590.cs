// Example of creating a web page with Blazor\nusing Microsoft.AspNetCore.Components;\n\nnamespace MyWebApp\n{\n    public class HelloWorld : ComponentBase\n    {\n        protected override void BuildRenderTree(RenderTreeBuilder builder)\n        {\n            builder.AddText("Hello, World!");\n        }\n    }\n}