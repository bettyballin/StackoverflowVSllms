using System;\n   using System.ServiceModel;\n   using System.ServiceModel.Activation;\n\n   public class CustomServiceHostFactory : ServiceHostFactory\n   {\n       protected override ServiceHost CreateServiceHost(Type serviceType, Uri[] baseAddresses)\n       {\n           // Adjust base addresses to account for different host headers\n           for (int i = 0; i < baseAddresses.Length; i++)\n           {\n               baseAddresses[i] = new Uri(baseAddresses[i].AbsoluteUri.Replace("*", "yourhostname.com"));\n           }\n\n           return new ServiceHost(serviceType, baseAddresses);\n       }\n   }