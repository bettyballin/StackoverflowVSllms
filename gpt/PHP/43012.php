use Doctrine\ORM\Tools\Setup;\nuse Doctrine\ORM\EntityManager;\n\n$config = Setup::createAnnotationMetadataConfiguration($paths, $isDevMode);\n$entityManager = EntityManager::create($dbParams, $config);