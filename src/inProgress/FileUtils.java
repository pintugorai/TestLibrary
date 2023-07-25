package inProgress;

import java.io.File;

public class FileUtils {
	public static long getFileSizeInBytes(String fileFullPath) {
		File file = new File(fileFullPath);
		return file.length();
	}
	public static void main(String[] args) {
		//long fileSize = file.length();
		//System.out.println("File size in bytes: " + FileUtils.getFileSizeInBytes(fileFullPath));
	}
}
