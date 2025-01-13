public class AuthenticationInterceptor : IInterceptor\n     {\n         public void Intercept(IInvocation invocation)\n         {\n             if (!Thread.CurrentPrincipal.Identity.IsAuthenticated)\n             {\n                 throw new UnauthorizedAccessException("User is not authenticated");\n             }\n\n             invocation.Proceed();\n         }\n     }