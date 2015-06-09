    /**
     * Formats a name and returns it with the first letter in
     * upper case and the rest in lower case (title case).
     * @param name the name to format
     * @return the correctly formatted name, as a String
     */
    public static final String formatName(String name)
    {
        if (name != null && name.trim().length() > 0) {
            String firstLetter = name.trim().toUpperCase().substring(0, 1);
            String theRest = name.trim().toLowerCase().substring(1);
            return firstLetter + theRest;
        }
        return null;
    }