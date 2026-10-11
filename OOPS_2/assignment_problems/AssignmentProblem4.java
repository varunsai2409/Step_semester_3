class AssignmentProblem4{
    private String color;
    private final String id;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public void next() {
        switch (color) {
            case "RED": color = "GREEN"; break;
            case "GREEN": color = "YELLOW"; break;
            case "YELLOW": color = "RED"; break;
        }
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor()); // RED
        t.next();
        System.out.println(t.getColor()); // GREEN
        t.next();
        System.out.println(t.getColor()); // YELLOW
        t.next();
        System.out.println(t.getColor()); // RED
    }
}
