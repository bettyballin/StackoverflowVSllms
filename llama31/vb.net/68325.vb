Dim proxy = generator.CreateClassProxyWithTarget(Of T)(target, New IgnoreMissingMethodsInterceptor())