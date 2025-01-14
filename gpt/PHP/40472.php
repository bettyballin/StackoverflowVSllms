use Gedmo\Mapping\Annotation as Gedmo;\n   use Doctrine\ORM\Mapping as ORM;\n\n   /**\n    * @ORM\Entity\n    * @ORM\Table(name="your_table_name")\n    */\n   class YourEntity\n   {\n       /**\n        * @var \DateTime\n        *\n        * @Gedmo\Timestampable(on="create")\n        * @ORM\Column(type="datetime")\n        */\n       private $createdAt;\n\n       /**\n        * @var \DateTime\n        *\n        * @Gedmo\Timestampable(on="update")\n        * @ORM\Column(type="datetime")\n        */\n       private $updatedAt;\n\n       // ... other fields and methods ...\n   }