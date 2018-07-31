package test;
import java.io.File;
import java.io.FileInputStream;
import util.ProcessUtil;

public class PCMTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] chunkID = new byte[4];
		byte[] format = new byte[4];
		byte[] audioFormat = new byte[2];
		byte[] numChannels = new byte[2];
		byte[] sampleRate = new byte[4];
		byte[] bitsPerSample = new byte[2];
		byte[] subChunk2_size=new byte[4];
		File file = new File("src/main/java/data/test.wav");
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(file);
			stream.read(chunkID);
			System.out.println("是否是RIFF格式：" + "RIFF".equals(new String(chunkID)));
			stream.skip(4);
			stream.read(format);
			System.out.println("文件格式：" + new String(format));
			stream.skip(8);
			stream.read(audioFormat);
			System.out.println("音频格式：" + ProcessUtil.ByteLittleToShort(audioFormat));
			stream.read(numChannels);
			System.out.println("声道数：" + ProcessUtil.ByteLittleToShort(numChannels));
			stream.read(sampleRate);
			System.out.println("采样率：" + ProcessUtil.ByteLittleToInt(sampleRate));
			stream.skip(6);
			stream.read(bitsPerSample);
			System.out.println("位深度：" + ProcessUtil.ByteLittleToShort(bitsPerSample));
			stream.skip(6);
			stream.read(subChunk2_size);
			System.out.println("数据节点长度："+ProcessUtil.ByteLittleToInt(subChunk2_size));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stream != null)
					stream.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}