import java.lang.String;
import java.io.Serializable; import javax.persistence.*; //...

@Entity public class Document implements Serializable { @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;  String name; @Lob private byte[] content; 
	public static void main(String[] args) {
	}
}