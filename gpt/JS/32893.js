// Pseudocode for linking OpenID to an existing account\nfunction linkOpenID(existingAccountId, openIDIdentifier) {\n    if (authenticateOpenID(openIDIdentifier)) {\n        // Store the association in the database\n        storeOpenIDAssociation(existingAccountId, openIDIdentifier);\n        return true;\n    } else {\n        return false;\n    }\n}