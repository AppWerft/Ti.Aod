package ti.aod;

import java.util.ArrayList;

public interface AsyncResponse {
	void processFinish(int id,ArrayList<Broadcast> broadcastsList);
	void processScheduler(int id,Dailyscheduler scheduler);
}
