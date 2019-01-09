import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

interface AlertDAO {
    UUID addAlert(Date time);
    Date getAlert(UUID id);
}


class AlertService {

    AlertDAO alertServiceAlertDAO;

    public AlertService (AlertDAO alertDAO){
        alertServiceAlertDAO = alertDAO;
    };

    private final MapAlertDAO storage = new MapAlertDAO();

    public UUID raiseAlert() {

        return alertServiceAlertDAO.addAlert(new Date());
        //return this.storage.addAlert(new Date());
    }

    public Date getAlertTime(UUID id) {

        return alertServiceAlertDAO.getAlert(id);
        //return this.storage.getAlert(id);
    }
}

class MapAlertDAO implements AlertDAO {
    private final Map<UUID, Date> alerts = new HashMap<UUID, Date>();

    public UUID addAlert(Date time) {
        UUID id = UUID.randomUUID();
        this.alerts.put(id, time);
        return id;
    }

    public Date getAlert(UUID id) {
        return this.alerts.get(id);
    }
}
