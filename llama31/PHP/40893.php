<style>\n  .errormsg3 {\n    text-align: center;\n    font-weight: bold;\n    color: white;\n    font-size: 16px;\n    background-color: red;\n    padding: 8px;\n    max-width: 600px;\n    display: block; /* or inline-block */\n    margin: 0 auto; /* center the div horizontally */\n  }\n  \n  .error-container {\n    padding: 10px; /* adjust this value as needed */\n    background-color: white;\n  }\n</style>\n\n<?php\nif (isset($_SESSION['sess_msg'])) {\n  echo '<div class="error-container"><div class="errormsg3">' . $_SESSION['sess_msg'] . '</div></div>';\n  unset($_SESSION['sess_msg']);\n}\n?>