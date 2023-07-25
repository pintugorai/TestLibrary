package testlib.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ChatGPTProcessUtil {
	public static List<String> getAllProcesses() {
		List<String> processes = new ArrayList<>();

		try {
			// Get the process builder
			ProcessBuilder builder = new ProcessBuilder("tasklist.exe");

			// Start the process
			Process process = builder.start();

			// Get the input stream of the process
			BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = input.readLine()) != null) {
				processes.add(line);
			}

			// Close the input stream
			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return processes;
	}

	public static void main(String[] args) {
		
		List<String> allProcess = ChatGPTProcessUtil.getAllProcesses();
		for (String s : allProcess) {
            System.out.println(s);
        }
		/*
		 * try { // Get the process builder ProcessBuilder builder = new
		 * ProcessBuilder("tasklist.exe");
		 * 
		 * // Start the process Process process = builder.start();
		 * 
		 * // Get the input stream of the process BufferedReader input = new
		 * BufferedReader(new InputStreamReader(process.getInputStream()));
		 * 
		 * String line; while ((line = input.readLine()) != null) { // Print the output
		 * System.out.println(line); }
		 * 
		 * // Close the input stream input.close();
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
	}
}
