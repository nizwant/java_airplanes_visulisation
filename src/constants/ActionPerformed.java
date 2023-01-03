package constants;

public enum ActionPerformed {
    MOVE_TO_NORTH("move_to_north"),
    MOVE_TO_SOUTH("move_to_south"),
    MOVE_TO_WEST("move_to_west"),
    MOVE_TO_EAST("move_to_east"),
    RESET_POS("reset_pos"),
    ZOOM_IN("zoom_in"),
    ZOOM_OUT("zoom_out");

    private final String _value;

    ActionPerformed(String pValue) {
        _value = pValue;
    }

    public static ActionPerformed fromString(String text) {
        for (var actionPerformed : ActionPerformed.values()) {
            if (actionPerformed.getValue().equalsIgnoreCase(text)) {
                return actionPerformed;
            }
        }

        return null;
    }

    public String getValue() {
        return this._value;
    }
}