package fs.qn;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class ScheduleBackup {

	public static Boolean createTimeBackup(int year, int month, int day, int hour, int minute, int dateEnd) {
		ScheduleTask task = new ScheduleTask();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date dateSchedule = calendar.getTime();
		long period = (24 * 60 * 60 * 1000) * dateEnd;

		Timer timer = new Timer();

		timer.schedule(task, dateSchedule, period);
		return true;
	}
}