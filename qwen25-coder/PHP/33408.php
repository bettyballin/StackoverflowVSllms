use Doctrine\ORM\Mapping as ORM;\n\n/**\n * @ORM\Entity\n * @ORM\HasLifecycleCallbacks()\n */\nclass MyEntity {\n\n    /**\n     * @ORM\PostLoad\n     */\n    public function postLoad() {\n        echo "Entity loaded...";\n    }\n}