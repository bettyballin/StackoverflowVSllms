// Part of webpack.config.js for minimizing JS and CSS using TerserPlugin and MiniCssExtractPlugin\n   const TerserPlugin = require("terser-webpack-plugin");\n   const MiniCssExtractPlugin = require('mini-css-extract-plugin');\n\n   module.exports = {\n     optimization: {\n       minimize: true,\n       minimizer: [new TerserPlugin()],\n     },\n     plugins: [\n       new MiniCssExtractPlugin({\n         filename: '[name].[contenthash].css'\n       })\n     ]\n   };