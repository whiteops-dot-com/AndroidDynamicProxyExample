package com.example.decoder;


import java.io.UnsupportedEncodingException;

/* renamed from: com.mb.num.d.a.a */
public class C12284a {

    /* renamed from: a */
    public static final byte[] f37579a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b */
    public static final byte[] f37580b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};

    /* renamed from: a */
    public static int m29350a(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i + 2;
        if (bArr[i3] == 61) {
            byte[] bArr3 = f37580b;
            bArr2[i2] = (byte) ((((bArr3[bArr[i + 1]] & 255) << 12) | ((bArr3[bArr[i]] & 255) << 18)) >>> 16);
            return 1;
        }
        int i4 = i + 3;
        if (bArr[i4] == 61) {
            byte[] bArr4 = f37580b;
            int i5 = ((bArr4[bArr[i3]] & 255) << 6) | ((bArr4[bArr[i + 1]] & 255) << 12) | ((bArr4[bArr[i]] & 255) << 18);
            bArr2[i2] = (byte) (i5 >>> 16);
            bArr2[i2 + 1] = (byte) (i5 >>> 8);
            return 2;
        }
        try {
            byte b = (byte)((f37580b[bArr[(byte)i4]] & (byte)255) | ((byte)(f37580b[bArr[i + 1]] & (byte)255) << (byte)12) | ((f37580b[bArr[i]] & (byte)255) << (byte)18) | ((f37580b[bArr[i3]] & (byte)255) << (byte)6));
            bArr2[i2] = (byte) (b >> 16);
            bArr2[i2 + 1] = (byte) (b >> 8);
            bArr2[i2 + 2] = (byte) b;
            return 3;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a */
    public static String m29351a(byte[] bArr) throws UnsupportedEncodingException {
        return m29352a(bArr, 0, bArr.length, true);
    }

    /* renamed from: a */
    public static String m29352a(byte[] bArr, int i, int i2, boolean z) throws UnsupportedEncodingException {
        int i3 = (i2 << 2) / 3;
        byte[] bArr2 = new byte[((i2 % 3 > 0 ? 4 : 0) + i3 + (z ? i3 / 76 : 0))];
        int i4 = i2 - 2;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i4) {
            m29356a(bArr, i5 + i, 3, bArr2, i6);
            i7 += 4;
            if (z && i7 == 76) {
                bArr2[i6 + 4] = 10;
                i6++;
                i7 = 0;
            }
            i5 += 3;
            i6 += 4;
        }
        if (i5 < i2) {
            m29356a(bArr, i + i5, i2 - i5, bArr2, i6);
            i6 += 4;
        }
        return new String(bArr2, 0, i6, "iso-8859-1");
    }

    /* renamed from: a */
    public static String m29353a(byte[] bArr, boolean z) throws UnsupportedEncodingException {
        return m29352a(bArr, 0, bArr.length, z);
    }

    /* renamed from: a */
    public static byte[] m29354a(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes("iso-8859-1");
        return m29355a(bytes, 0, bytes.length);
    }

    /* renamed from: a */
    public static byte[] m29355a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[((i2 * 3) / 4)];
        byte[] bArr3 = new byte[4];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            byte b = (byte) (bArr[i5] & Byte.MAX_VALUE);
            byte b2 = f37580b[b];
            if (b2 < -5) {
                return null;
            }
            if (b2 >= -1) {
                int i6 = i3 + 1;
                bArr3[i3] = b;
                if (i6 > 3) {
                    i4 += m29350a(bArr3, 0, bArr2, i4);
                    if (b == 61) {
                        break;
                    }
                    i3 = 0;
                } else {
                    i3 = i6;
                }
            }
        }
        byte[] bArr4 = new byte[i4];
        System.arraycopy(bArr2, 0, bArr4, 0, i4);
        return bArr4;
    }

    /* renamed from: a */
    public static byte[] m29356a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = 0;
        int i5 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0);
        if (i2 > 2) {
            i4 = (bArr[i + 2] << 24) >>> 24;
        }
        int i6 = i5 | i4;
        if (i2 == 1) {
            byte[] bArr3 = f37579a;
            bArr2[i3] = bArr3[i6 >>> 18];
            bArr2[i3 + 1] = bArr3[(i6 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            byte[] bArr4 = f37579a;
            bArr2[i3] = bArr4[i6 >>> 18];
            bArr2[i3 + 1] = bArr4[(i6 >>> 12) & 63];
            bArr2[i3 + 2] = bArr4[(i6 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            byte[] bArr5 = f37579a;
            bArr2[i3] = bArr5[i6 >>> 18];
            bArr2[i3 + 1] = bArr5[(i6 >>> 12) & 63];
            bArr2[i3 + 2] = bArr5[(i6 >>> 6) & 63];
            bArr2[i3 + 3] = bArr5[i6 & 63];
            return bArr2;
        }
    }
}