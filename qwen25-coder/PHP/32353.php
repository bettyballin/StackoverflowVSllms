amespace App\EventSubscriber;\n\nuse Doctrine\Common\EventSubscriber;\nuse Doctrine\ORM\Events;\nuse Doctrine\Persistence\Event\LifecycleEventArgs;\nuse App\Entity\YourEntity; // Adjust namespace and entity name as needed\n\nclass TimestampsSubscriber implements EventSubscriber\n{\n    public function getSubscribedEvents()\n    {\n        return [\n            Events::prePersist,\n            Events::preUpdate,\n        ];\n    }\n\n    public function prePersist(LifecycleEventArgs $args)\n    {\n        $entity = $args->getObject();\n        \n        if (!$entity instanceof YourEntity) {\n            return;\n        }\n        \n        $this->updateTimestamps($entity);\n    }\n\n    public function preUpdate(LifecycleEventArgs $args)\n    {\n        $entity = $args->getObject();\n        \n        if (!$entity instanceof YourEntity) {\n            return;\n        }\n        \n        $this->updateTimestamps($entity, false);\n    }\n\n    private function updateTimestamps(YourEntity $entity, bool $isNew = true)\n    {\n        if ($isNew || is_null($entity->getCreatedAt())) {\n            $entity->setCreatedAt(time());\n        }\n        \n        $entity->setUpdatedAt(time());\n    }\n}