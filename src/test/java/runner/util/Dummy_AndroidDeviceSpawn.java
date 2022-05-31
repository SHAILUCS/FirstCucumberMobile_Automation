package runner.util;

import java.io.IOException;

public class Dummy_AndroidDeviceSpawn {
	public static synchronized void excCommand(String deviceName) {
		try {
			String[] command = {  "cmd.exe", "/c", "cd %ANDROID_HOME%\\emulator", "emulator -avd " + deviceName };
			ProcessBuilder builder = new ProcessBuilder(command);
			//builder = builder.directory(new File("/ngs/app/abc"));
			Process p = builder.start();

			
			
			Thread.sleep(20000);

			p.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		excCommand("Pixel_4_API_30");
	}
}
