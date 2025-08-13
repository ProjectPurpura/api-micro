package org.purpura.apimicro.common;

import java.awt.*;

public class Colors {
    public static final String DEFAULT_FORE_QR_COLOR = "#000000";
    public static final String DEFAULT_BACK_QR_COLOR = "#FFFFFF";

    public static Color fromHex(String hex) {
        return Color.decode(hex);
    }
}
