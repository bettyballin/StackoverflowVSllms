<?php\n\nnamespace Drupal\mymodule\Services;\n\nuse Drupal\Core\Session\AccountInterface;\nuse Drupal\Core\Entity\EntityTypeManagerInterface;\n\nclass NodeFieldService {\n  \n  protected $currentUser;\n  protected $entityTypeManager;\n\n  public function __construct(AccountInterface $current_user, EntityTypeManagerInterface $entity_type_manager) {\n    $this->currentUser = $current_user;\n    $this->entityTypeManager = $entity_type_manager;\n  }\n\n}