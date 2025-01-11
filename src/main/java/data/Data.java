package data;

public enum Data {

    ICON("resources/images/gameIcon.png"),
    FONT("resources/fonts/Montserrat-Bold.ttf");

    private final String path;

    Data(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}