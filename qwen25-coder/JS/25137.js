let user = {\n    firstName: 'John',\n    lastName: null,  // Explicitly indicates this field has no value\n    middleName: undefined  // This field hasn't been initialized yet, or isn't applicable\n};\n\nfunction displayUser(user) {\n    if (user.lastName === null) {\n        console.log("Last name not provided.");\n    } else {\n        console.log(`Last Name: ${user.lastName}`);\n    }\n    \n    if ('middleName' in user && user.middleName !== undefined) {\n        console.log(`Middle Name: ${user.middleName}`);\n    } else {\n        console.log("Middle name does not apply or not initialized yet.");\n    }\n}\n\ndisplayUser(user);