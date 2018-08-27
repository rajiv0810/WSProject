package hr.service;
// package got imported
import java.util.Date;

public interface HumanResourceService {
	void bookLeave(Date startDate, Date endDate, String name);
}
