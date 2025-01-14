// Example of using a Trie in JavaScript\nclass TrieNode {\n    constructor() {\n        this.children = {};\n        this.isEndOfWord = false;\n    }\n}\n\nclass Trie {\n    constructor() {\n        this.root = new TrieNode();\n    }\n\n    insert(word) {\n        let node = this.root;\n        for (let char of word) {\n            if (!node.children[char]) \n                node.children[char] = new TrieNode();\n            node = node.children[char];\n        }\n        node.isEndOfWord = true;\n    }\n\n    search(word) {\n        let node = this.root;\n        for (let char of word) {\n            if (!node.children[char]) return false;\n            node = node.children[char];\n        }\n        return node.isEndOfWord;\n    }\n}