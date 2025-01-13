<?php foreach ($types as $type): ?>\n    <div>\n        <?php if ($type['Type']['is_rtf']): // Assuming 'is_rtf' is the flag for RTF types ?>\n            <?php echo $this->Html->link('View RTF', array('action' => 'view', $type['Type']['id'])); ?>\n        <?php else: ?>\n            <?php echo h($type['Type']['name']); ?>\n        <?php endif; ?>\n    </div>\n<?php endforeach; ?>