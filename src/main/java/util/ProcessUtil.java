package util;

public class ProcessUtil {
	public static short ByteLittleToShort(byte[] src) {
		short value;
		value = (short) ((src[0] & 0xFF) | ((src[0 + 1] & 0xFF) << 8));
		return value;
	}

	public static int ByteLittleToInt(byte[] src) {
		int value;
		value = (int) ((src[0] & 0xFF) | ((src[0 + 1] & 0xFF) << 8) | ((src[0 + 2] & 0xFF) << 16)
				| ((src[0 + 3] & 0xFF) << 24));
		return value;
	}
	
	public static void ByteArrayToShortArray(byte[] b,short[] s){
		int lengthB=b.length;
		int lengthS=lengthB/2;
		for(int i=0;i<lengthS;){
			s[i]=(short)((b[i++]&0xFF)|((b[i++]&0xFF)<<8));
		}
	}
}
