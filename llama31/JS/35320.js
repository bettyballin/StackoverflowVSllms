const $ = require('jquery');\nconst html = '<h1>First level1 heading</h1>...'; // your HTML content\n\n$(html).toc({\n  headers: 'h1, h2',\n  container: '#toc'\n});\n\n// Output:\n// <div id="toc">\n//   <ul>\n//     <li><a href="#first-level1-heading">First level1 heading</a>\n//       <ul>\n//         <li><a href="#1a-heading">1a heading</a></li>\n//         <li><a href="#1b-heading">1b heading</a></li>\n//       </ul>\n//     </li>\n//     <li><a href="#second-level1-heading">Second level1 heading</a></li>\n//   </ul>\n// </div>