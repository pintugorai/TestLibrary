package testlib.process;

import java.io.InputStreamReader;
import java.io.Reader;

public class GetProcessID {

	/**
	 * Get process ID(PID) of a given port number for Windows
	 * 
	 * @param port
	 * @return
	 * @author Pintu
	 */
	public static int getPidWindows(int port) {
		String[] command = { "netstat", "-on" };
		try {
			Process netstat = Runtime.getRuntime().exec(command);

			StringBuilder conectionList = new StringBuilder();
			Reader reader = new InputStreamReader(netstat.getInputStream());
			char[] buffer = new char[1024];
			for (int n = reader.read(buffer); n != -1; n = reader.read(buffer)) {
				conectionList.append(buffer, 0, n);
			}
			reader.close();
			String[] conections = conectionList.toString().split("\n");
			int portIdx = 10000;
			String pid = null;
			for (String conection : conections) {
				int idx = conection.indexOf(":" + port);
				if (idx == -1 || idx > portIdx) {
					continue;
				}
				String state = "ESTABLISHED";
				int stateIdx = conection.indexOf(state);
				if (stateIdx == -1) {
					continue;
				}
				portIdx = idx;
				idx = stateIdx + state.length();
				pid = conection.substring(idx).trim();
			}
			if (pid != null) {
				return Integer.valueOf(pid);
			}

		} catch (Exception e) {
		}

		return 0;

	}

	/**
	 * Get process ID(PID) of a given port number for Linux OS
	 * 
	 * @param port
	 * @return process id(PID)
	 * @author Pintu
	 */
	public static int getPidLinux(int port) {
		String[] command = { "netstat", "-anp" };
		try {
			Process netstat = Runtime.getRuntime().exec(command);

			StringBuilder conectionList = new StringBuilder();
			Reader reader = new InputStreamReader(netstat.getInputStream());
			char[] buffer = new char[1024];
			for (int n = reader.read(buffer); n != -1; n = reader.read(buffer)) {
				conectionList.append(buffer, 0, n);
			}
			reader.close();
			String[] conections = conectionList.toString().split("\n");
			String pid = null;
			for (String conection : conections) {
				if (conection.contains(":" + port) && conection.contains("/soffice.bin")) {
					int idx = conection.indexOf("/soffice.bin");
					int idx2 = idx;
					while (Character.isDigit(conection.charAt(--idx2)))
						;
					pid = conection.substring(idx2 + 1, idx);
				}
			}
			if (pid != null) {
				return Integer.valueOf(pid);
			}

		} catch (Exception e) {
		}

		return 0;
	}

	/**
	 * Get process ID(PID) of a given port number
	 * 
	 * @param port_number
	 * @return
	 * @author Pintu
	 */
	public static int getPid(int port_number) {
		if (System.getProperty("os.name").startsWith("Windows")) {
			return getPidWindows(port_number);
		} else {
			return getPidLinux(port_number);
		}
	}

	public static void main(String[] args) {

		System.out.println(System.getProperty("os.name"));
		System.out.println(getPid(55061));

	}
}
