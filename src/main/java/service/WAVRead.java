package service;

import java.io.*;

public class WAVRead{
	public static void main(String[] args) {
		File file=new File("resource/test.wav");
		FileInputStream stream=null;
		
		try {
			stream.skip(46);
			int i=0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if(stream!=null)
					stream.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
