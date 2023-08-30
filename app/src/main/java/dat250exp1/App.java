package dat250exp1;

import io.javalin.Javalin;

public class App {

    private static final String WEBPAGE = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Convert units</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>Unit converter</h1>\n" +
            "<form action=\"/convert\" method=\"post\">\n" +
            "    <fieldset>\n" +
            "    <label for=\"val\">Value:</label>" +
            "    <input id=\"val\" type=\"text\" name=\"value\"><br />\n" +
            "    <label for=\"source-unit\">From unit:</label>\n" +
            "    <select name=\"sunit\" id=\"source-unit\">\n" +
            "        <option value=\"in\">Inches</option>\n" +
            "        <option value=\"ft\">Feet</option>\n" +
            "        <option value=\"mi\">Miles</option>\n" +
            "        <option value=\"m\">Metres</option>\n" +
            "    </select><br />\n" +
            "    <label for=\"target-unit\">To unit:</label>\n" +
            "    <select name=\"tunit\" id=\"target-unit\">\n" +
            "        <option value=\"in\">Inches</option>\n" +
            "        <option value=\"ft\">Feet</option>\n" +
            "        <option value=\"mi\">Miles</option>\n" +
            "        <option value=\"m\">Metres</option>\n" +
            "    </select><br />\n" +
            "    <input type=\"submit\" value=\"Calculate\" />\n" +
            "    </fieldset>\n" +
            "</form>\n" +
            "</body>\n" +
            "</html>";

    private static final double IN_TO_METER = 0.0254;
    private static final double FT_TO_METER = 0.3048;
    private static final double MI_TO_METER = 1609.344;


    public static void main(String[] args) {
        Javalin.create()
        .get("/", ctx -> {
            ctx.html(WEBPAGE);
        })
                .post("/convert", ctx -> {
                    double value = Double.parseDouble(ctx.formParam("value"));
                    String fromUnit = ctx.formParam("sunit");
                    String toUnit = ctx.formParam("tunit");

                    double result = convertUnits(value, fromUnit, toUnit);

                    ctx.result(Double.toString(result));
                })
                .start(9000);
    }

    /** Converts a value from one unit to another.
      1      *
            * @param value    The value to be converted.
            * @param fromUnit The unit to convert from (e.g., "in", "ft", "mi", "m").
            * @param toUnit   The unit to convert to (e.g., "in", "ft", "mi", "m").
            * @return The converted value.
     */
    private static double convertUnits(double value, String fromUnit, String toUnit) {
        double fromMultiplier = 1.0; // Default value
        double toMultiplier = 1.0;   // Default value

        // Determine multipliers based on units
        if (fromUnit.equals("in")) {
            fromMultiplier = IN_TO_METER;
        } else if (fromUnit.equals("ft")) {
            fromMultiplier = FT_TO_METER;
        } else if (fromUnit.equals("mi")) {
            fromMultiplier = MI_TO_METER;
        } else if (fromUnit.equals("m")) {
            // No need to change the default value
        } else {
            // Handle invalid unit
            return Double.NaN;
        }

        if (toUnit.equals("in")) {
            toMultiplier = 1 / IN_TO_METER;
        } else if (toUnit.equals("ft")) {
            toMultiplier = 1 / FT_TO_METER;
        } else if (toUnit.equals("mi")) {
            toMultiplier = 1 / MI_TO_METER;
        } else if (toUnit.equals("m")) {
            // No need to change the default value
        } else {
            // Handle invalid unit
            return Double.NaN;
        }

        // Perform conversion
        double inMeters = value * fromMultiplier;
        double result = inMeters * toMultiplier;

        return result;
    }





}