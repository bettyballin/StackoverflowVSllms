use Doctrine\Common\Persistence\Event\LifecycleEventArgs;\n\n  class SearchIndexer\n  {\n      private $elasticsearchClient;\n\n      public function __construct($elasticsearchClient)\n      {\n          $this->elasticsearchClient = $elasticsearchClient;\n      }\n\n      public function postPersist(LifecycleEventArgs $args)\n      {\n          $entity = $args->getObject();\n          $this->indexEntity($entity);\n      }\n\n      public function postUpdate(LifecycleEventArgs $args)\n      {\n          $entity = $args->getObject();\n          $this->indexEntity($entity);\n      }\n\n      public function postRemove(LifecycleEventArgs $args)\n      {\n          $entity = $args->getObject();\n          $this->removeEntityFromIndex($entity);\n      }\n\n      private function indexEntity($entity)\n      {\n          // Code to index entity in Elasticsearch\n      }\n\n      private function removeEntityFromIndex($entity)\n      {\n          // Code to remove entity from Elasticsearch index\n      }\n  }