public class Restaurant {
    private Restaurant _instance = null;
    public static Restaurant getInstance() {
        if (_instance == null) {
            _instance = new Restaurant();
        }
        return _instance;
    }
}


