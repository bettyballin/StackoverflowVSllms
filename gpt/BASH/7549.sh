# Install Stylelint\nnpm install stylelint stylelint-config-standard --save-dev\n\n# Create a stylelint configuration file\necho '{\n  "extends": "stylelint-config-standard"\n}' > .stylelintrc.json\n\n# Run Stylelint on your CSS files\nnpx stylelint "**/*.css"\n\n# Install CSSNano\nnpm install cssnano --save-dev\n\n# Minify your CSS\nnpx cssnano input.css output.min.css