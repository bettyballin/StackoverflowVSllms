// Example of a conditional check in Joomla's template override index.php\nif ($this->countModules('position-0')) : ?>\n    <div class="header" id="header">\n        <!-- Header Content -->\n        <?php if ($this->_showTitle) { ?>\n            <!-- Ensure this block does not output "Welcome to the Frontpage" -->\n            <h1><?php echo htmlspecialchars($this->_title); ?></h1>\n        <?php } ?>\n    </div>\n<?php endif; ?>