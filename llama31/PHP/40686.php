.use Doctrine\DBAL\DriverManager;\nuse Doctrine\DBAL\Query\QueryBuilder;\n\n$conn = DriverManager::getConnection(['url' => 'mysql://user:password@host/dbname']);\n$queryBuilder = $conn->createQueryBuilder();\n$queryBuilder->select('u')\n    ->from('users', 'u')\n    ->where('u.name = :name AND u.email = :email')\n    ->setParameter('name', $name)\n    ->setParameter('email', $email);