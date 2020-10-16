public class NumeralSystemConverter {


    String convert(int sourceRadix, String sourceNumber, int targetRadix) {
        String result;
        String[] parts = sourceNumber.split("\\.");
        String sourceNumberIntPart = parts[0];
        result = intToString(parseIntPart(sourceNumberIntPart, sourceRadix), targetRadix);
        if (parts.length == 2) {
            String sourceNumberFractionalPart = parts[1];
            result += "." + fractionalToString(parseFractionalPart(sourceNumberFractionalPart, sourceRadix), targetRadix);
        }
        return result;
    }

    int parseIntPart(String number, int radix) {
        return radix == 1 ? number.length() : Integer.parseInt(number, radix);
    }

    double parseFractionalPart(String fractional, int radix) {
        double decimalVal = 0;
        int exp = 1;
        for (char ch : fractional.toCharArray()) {
            decimalVal += (double) Character.getNumericValue(ch) / Math.pow(radix, exp);
            exp++;
        }
        return decimalVal;
    }

    String intToString(int number, int radix) {
        String s;
        if (radix != 1) {
            s = Integer.toString(number, radix);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < number; i++) {
                sb.append("1");
            }
            s = sb.toString();
        }
        return s;
    }

    String fractionalToString(double fractional, int radix) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            String st = String.valueOf(fractional * radix);
            int intPart = Integer.parseInt(st.substring(0, st.indexOf(".")));
            fractional = Double.parseDouble(st.substring(st.indexOf(".")));
            builder.append(Character.forDigit(intPart, radix));
        }
        return builder.toString();
    }

}