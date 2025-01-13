/*
 * Decompiled with CFR 0.152.
 */
class PieceRequest {
    private int pieceIndex;
    private int pieceLength;

    public PieceRequest(int n, int n2) {
        this.pieceIndex = n;
        this.pieceLength = n2;
    }

    public byte[] getMessage() {
        return ("Piece request: " + this.pieceIndex + ", " + this.pieceLength).getBytes();
    }
}
