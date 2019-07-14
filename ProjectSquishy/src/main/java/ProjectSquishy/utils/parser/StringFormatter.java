package ProjectSquishy.utils.parser;

public class StringFormatter {

    public String formatSrcString (String unformattedString) {

        try {
            String formattedString = unformattedString.substring(unformattedString.indexOf("/commons"), unformattedString.indexOf("g\"") + 1);
            return formattedString;
        }catch (StringIndexOutOfBoundsException e){
        }
        return "Empty string found";
    }

    public String formatPlayerName (String unformattedString){
        return unformattedString.substring(0,unformattedString.length()/2);
    }
}