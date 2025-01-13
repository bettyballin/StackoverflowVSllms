/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bouncycastle.asn1.ASN1Encodable
 *  org.bouncycastle.asn1.ASN1EncodableVector
 *  org.bouncycastle.asn1.ASN1Integer
 *  org.bouncycastle.asn1.ASN1Sequence
 *  org.bouncycastle.asn1.DEROctetString
 *  org.bouncycastle.asn1.DERSequence
 */
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

public class ASN1Example {
    public static void main(String[] stringArray) throws Exception {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add((ASN1Encodable)new ASN1Integer(1L));
        aSN1EncodableVector.add((ASN1Encodable)new DEROctetString("Hello, World!".getBytes()));
        DERSequence dERSequence = new DERSequence(aSN1EncodableVector);
        byte[] byArray = dERSequence.getEncoded();
        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance((Object)byArray);
        System.out.println(aSN1Sequence);
    }
}
