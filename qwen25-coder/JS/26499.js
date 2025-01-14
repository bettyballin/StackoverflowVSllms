function spiralOrder(matrix) {\n    if (matrix.length === 0) return [];\n\n    const result = [];\n    let topRow = 0;\n    let bottomRow = matrix.length - 1;\n    let leftCol = 0;\n    let rightCol = matrix[0].length - 1;\n\n    while (topRow <= bottomRow && leftCol <= rightCol) {\n        // Traverse from left to right along the top row\n        for (let i = leftCol; i <= rightCol; i++) {\n            result.push(matrix[topRow][i]);\n        }\n        topRow++;\n\n        // Traverse downwards along the right column\n        for (let i = topRow; i <= bottomRow; i++) {\n            result.push(matrix[i][rightCol]);\n        }\n        rightCol--;\n\n        if (topRow <= bottomRow) {\n            // Traverse from right to left along the bottom row\n            for (let i = rightCol; i >= leftCol; i--) {\n                result.push(matrix[bottomRow][i]);\n            }\n            bottomRow--;\n        }\n\n        if (leftCol <= rightCol) {\n            // Traverse upwards along the left column\n            for (let i = bottomRow; i >= topRow; i--) {\n                result.push(matrix[i][leftCol]);\n            }\n            leftCol++;\n        }\n    }\n\n    return result;\n}\n\n// Example usage:\nconst matrix = [\n    [1, 2, 3],\n    [4, 5, 6],\n    [7, 8, 9]\n];\n\nconsole.log(spiralOrder(matrix)); // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]