const marked = require('marked');\n\nconst renderer = new marked.Renderer();\nrenderer.image = () => ''; // disable images\nrenderer.heading = () => ''; // disable headings\n\nconst markdown_text = '**bold** and ![image](http://example.com)';\nconst html = marked(markdown_text, { renderer });\n\nconsole.log(html);