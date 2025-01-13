import org.bouncycastle.asn1.*;

public class ASN1Example {
    public static void main(String[] args) throws Exception {
        // Create an ASN.1 sequence
        ASN1EncodableVector vector = new ASN1EncodableVector();
        vector.add(new ASN1Integer(1));
        vector.add(new DEROctetString("Hello, World!".getBytes()));
        ASN1Sequence seq = new DERSequence(vector);

        // Encode the sequence to a byte array
        byte[] encoded = seq.getEncoded();

        // Decode the byte array back to an ASN.1 sequence
        ASN1Sequence decodedSeq = ASN1Sequence.getInstance(encoded);

        // Print the decoded sequence
        System.out.println(decodedSeq);
    }
}