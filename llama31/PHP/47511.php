if (!in_array($kind, ['kind1', 'kind2', ..., 'kindn'])) {\n    $kind = 'kind1';\n}\n\nswitch($kind) {\n    case 'kind1':\n        // Do some stuff for kind 1 here\n        break;\n\n    case 'kind2':\n        // do some stuff for kind2 here\n        break;\n\n    // [...]\n\n    case 'kindn':\n        // do some stuff for kindn here\n        break;\n}