const element = document.querySelector('div');\nconst attributes = element.attributes;\n\nfor (let i = 0; i < attributes.length; i++) {\n    const attr = attributes[i];\n    console.log(`${attr.name} = ${attr.value}`);\n}