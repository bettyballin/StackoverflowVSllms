// Assembly 1\n   using CommonAssembly;\n   \n   [Export("sword")]\n   public class Sword : IWeapon {\n       public int Might {\n           get { return 10; }\n       }\n   }