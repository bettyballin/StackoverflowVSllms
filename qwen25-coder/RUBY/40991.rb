<h1 id="welcome_sign">Welcome!</h1>\n<h3 id="sitemap">Site Map</h3>\n\n<ul>\n    <li><%= link_to "Animals", "/animals" %>\n        <ol>\n            <li><%= link_to "Hello", "/animals/hello" %></li>\n        </ol>\n    </li>\n    <li><%= link_to "Machines", "/machines" %>\n        <ol>\n            <li><%= link_to "Products", "/machines/products" %></li>\n            <li><%= link_to "Report", "/machines/report" %></li>\n            <li><%= link_to "Robot", "/machines/robot" %></li>\n            <li><%= link_to "Show", "/machines/show" %></li>\n        </ol>\n    </li>\n</ul>