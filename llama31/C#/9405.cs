OperationContextScope scope = new OperationContextScope(proxy.InnerChannel);\nOperationContext.Current.ClientCredentials.UserName.UserName = "test";\nOperationContext.Current.ClientCredentials.UserName.Password = "pass";\n\n// Make service call here\n\nscope.Close();