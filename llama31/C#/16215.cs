X509Certificate2 cert = ...;\nX509ExtensionCollection extensions = cert.Extensions;\nforeach (X509Extension ext in extensions)\n{\n    // access the extension data\n}