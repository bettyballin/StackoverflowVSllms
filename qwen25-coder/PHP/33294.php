// Example Symfony Form Type class\n   use Symfony\Component\Form\AbstractType;\n   use Symfony\Component\Form\FormBuilderInterface;\n\n   class ApplicationFormType extends AbstractType {\n       public function buildForm(FormBuilderInterface $builder, array $options) {\n           $builder\n               ->add('firstName')\n               ->add('lastName')\n               ->add('email');\n               // Add more fields...\n       }\n   }