// application/views/scripts/partials/content.phtml\n\n// Render content based on controller and action\necho $this->action($this->content['action'], $this->content['controller'], null, ['content' => $this->content]);