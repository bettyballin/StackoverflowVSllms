// User entity\nuse Doctrine\ORM\Mapping as ORM;\n\n/**\n * @ORM\Entity\n * @ORM\Table(name="users")\n */\nclass User {\n    /**\n     * @ORM\Id\n     * @ORM\Column(type="integer")\n     */\n    private $id;\n\n    /**\n     * @ORM\Column(type="string")\n     */\n    private $name;\n\n    // Getters and setters\n}\n\n// Usage\n$entityManager = // get the entity manager instance\n$user = $entityManager->getRepository(User::class)->find(1);