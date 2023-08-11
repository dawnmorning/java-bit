package prob2;

public class SmartPhone extends MusicPhone {
	public void execute(String function) {
		if (function.equals("음악")) {
			downloadAndPlayMusic();
			return;
		}
		if (function.equals("앱")) {
			runApp();
			return;
		}
		super.execute(function);
	}
	public void downloadAndPlayMusic() {
		System.out.println("다운로드해서 음악 재생");
	}
	public void runApp() {
		System.out.println("앱실행");
	}
}
