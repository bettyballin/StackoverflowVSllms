use Symfony\Component\String\UnicodeString;\n\n   $myName = new UnicodeString(' my name ');\n   echo $myName->trim()->upper(); // Outputs: 'MY NAME'