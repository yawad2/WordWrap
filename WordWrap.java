import java.util.Scanner;
public class WordWrap {
    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in); //create a new scanner object
        int maxLength = 0; // max length of output line
        boolean line1 = true; // boolean to determine if there's a line at the beginning
        String oldLine = ""; // the line scanned
        String buffer = ""; // the buffer into which we add text
        while (scnr.hasNextLine()) { // while there's a new line
            String line = scnr.nextLine(); // scan that line
            //if line is blank, add a blank line to the buffer and update the value of the new line
            if (line.isBlank()) {
                buffer += oldLine + "\n" + "\n";
                oldLine = "";
            }
            if (line.equals("Stop.")) { // if the line says stop then get out of the loop
                buffer += oldLine;
                break;
            }
            if (line1 == true) {
                line1= false;
                maxLength = Integer.parseInt(line); // get the integer value of max length
                line = "";
            }
            // add remaining text to new line
            if (oldLine.equals("") == false)
                line = oldLine + " " + line.trim();

            // get rid of extra whitespace
            String noSpace = line.replaceAll("\\s+", " ");

            // wordWrap
            while (noSpace.length() > maxLength) { // when line exceeds the allowed length
                if (noSpace.charAt(maxLength) == ' ') { // if the string doesn't exceed the limit yet, take more input
                    buffer += noSpace.substring(0, maxLength) + "\n";
                    noSpace = noSpace.substring(maxLength +1); // update the value of the input string
                }
                else {
                    if (noSpace.contains(" ")) {
                        int i = noSpace.substring(0, maxLength).lastIndexOf(" "); // determine the index (i) of last occurrence of a white space
                        if (i == -1) { // for long words with no white space
                            i = noSpace.indexOf(" ");
                        }
                        buffer += noSpace.substring(0, i) + "\n"; // add that long word to the buffer
                        noSpace = noSpace.substring(i + 1); // update the value of the input string
                    }
                    else {
                        break;
                    }
                }
            }
            oldLine = noSpace;
        }
        // print the final buffer
        System.out.println(buffer);
    }
}