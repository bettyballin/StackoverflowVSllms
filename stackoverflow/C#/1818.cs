using (WindowsImpersonationContextFacade impersonationContext\n     = new WindowsImpersonationContextFacade(\n                    Settings.Default.ImpersonationDomain, \n                    Settings.Default.ImpersonationUser,\n                    Settings.Default.ImpersonationPass))\n                {\n                    transactions  = TransactionLoader.Load(filePath);\n                }