<!DOCTYPE html>\n<html>\n<head>\n    <title><?= $this->fetch('title') ?></title>\n    <?= $this->Html->meta('icon') ?>\n    <!-- Common styles and scripts -->\n</head>\n<body>\n    <header>\n        <?php // Similar header code here ?>\n    </header>\n    \n    <main class="content">\n        <?= $this->fetch('content') ?>\n    </main>\n    \n    <footer>\n        <!-- Footer details, if common or included from element -->\n    </footer>\n</body>\n</html>