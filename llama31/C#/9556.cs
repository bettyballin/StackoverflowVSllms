ServicePointManager.ServerCertificateValidationCallback += \n    (sender, certificate, chain, sslPolicyErrors) => \n    {\n        if (certificate.Thumbprint == "expected-thumbprint-value")\n        {\n            return true;\n        }\n        else\n        {\n            return false;\n        }\n    };