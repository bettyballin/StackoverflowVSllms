<?php if (isset($this->errorMessage) && !empty($this->errorMessage)): ?>\n    <div class="error">\n        <?php echo $this->escape($this->errorMessage[0]); ?>\n    </div>\n<?php endif; ?>