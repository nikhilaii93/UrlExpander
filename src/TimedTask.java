import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimedTask {
	Timer timer = new Timer();
	TimerTask exitApp = new TimerTask() {
		public void run() {
			System.exit(0);
		}
	};

	public TimedTask(int sec) {
		timer.schedule(exitApp, new Date(System.currentTimeMillis() + sec * 1000));
	}

}