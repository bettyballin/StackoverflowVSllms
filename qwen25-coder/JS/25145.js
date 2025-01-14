module.exports = {\n  plugins: [\n    require('@fullhuman/postcss-purgecss')({\n      content: [\n        './**/*.html',\n        './**/*.jsp', // Make sure to include all file types that could reference CSS\n        './js/**/*.js'\n      ],\n      defaultExtractor: content => content.match(/[\w-/:]+(?<!:)/g) || []\n    }),\n  ]\n}