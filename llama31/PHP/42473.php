// In your view\n<div class="paging">\n    <?php echo $this->Paginator->prev('<< Previous', null, null, array('class' => 'disabled')); ?>\n    | <?php echo $this->Paginator->numbers(); ?>\n    <?php echo $this->Paginator->next('Next >>', null, null, array('class' => 'disabled')); ?>\n</div>