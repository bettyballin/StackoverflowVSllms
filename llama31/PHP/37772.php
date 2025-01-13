$environment = getenv('ENVIRONMENT');\n\nswitch ($environment) {\n    case 'development':\n        // configure DB connections, error reporting, etc. for development environment\n        break;\n    case 'staging':\n        // configure DB connections, error reporting, etc. for staging environment\n        break;\n    case 'production':\n        // configure DB connections, error reporting, etc. for production environment\n        break;\n    default:\n        // handle unknown environment\n        break;\n}