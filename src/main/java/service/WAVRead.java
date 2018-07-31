package service;

import java.io.*;

import util.ProcessUtil;

public class WAVRead{
	public static void main(String[] args) throws FileNotFoundException {
		File file=new File("resource/test.wav");
		FileInputStream input=null;
		FileOutputStream output=null;
		byte[] subChunk2_size=new byte[4];
		int dataSize=0;
		try {
			input.skip(46);
			int i=0;
			input.read(subChunk2_size);
			dataSize=ProcessUtil.ByteLittleToInt(subChunk2_size);
			byte[] data=new byte[dataSize];
			input.read(data);
			short[] dataS=new short[dataSize/2];
			ProcessUtil.ByteArrayToShortArray(data, dataS);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if(input!=null)
					input.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
