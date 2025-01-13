// src/Template/Layout/default.ctp\n   <!DOCTYPE html>\n   <html>\n   <head>\n       <?= $this->Html->charset() ?>\n       <title>\n           <?= $this->fetch('title') ?>\n       </title>\n       <?= $this->Html->css('styles') ?>\n       <?= $this->fetch('meta') ?>\n       <?= $this->fetch('css') ?>\n       <?= $this->fetch('script') ?>\n   </head>\n   <body>\n       <?= $this->element('menu') ?>\n       <div class="container">\n           <?= $this->Flash->render() ?>\n           <?= $this->fetch('content') ?>\n       </div>\n   </body>\n   </html>