// In your view (e.g., index.ctp)\n\n<?= $this->Form->create(null, ['type' => 'get']) ?>\n<?= $this->Form->control('search', ['label' => 'Search by surname']) ?>\n<?= $this->Form->button('Search') ?>\n<?= $this->Form->end() ?>\n\n// Display the paginated list of people\n<?= $this->element('People/list') ?>