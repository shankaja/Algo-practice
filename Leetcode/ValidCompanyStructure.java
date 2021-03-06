import java.util.*;

public class ValidCompanyStructure {

    public static void main(String[] args) {
        System.out.println(validateCompanyStrcuture(Arrays.asList("B A", "C B", "D B", "E D", "F E", "B F")));
    }

    public static String validateCompanyStrcuture(List<String> reportingLines) {
        Set<String> ceos = new TreeSet<>();
        Set<String> cycles = new HashSet<>();
        Map<String, String> employees = new HashMap<>();
        for (String reportingLine : reportingLines) {
            String[] s = reportingLine.split(" ");
            //if the entry is already a supervisor, it will be removed
            //optional
            ceos.remove(s[0]);
            ceos.add(s[1]);

            employees.put(s[0], s[1]);
        }

        //Loop scenario
        ceos.forEach(ceo -> {
            if (employees.get(ceo) != null) {
                cycles.add(ceo);
            }
        });
        String loopString = checkLoops(cycles, employees, ceos);
        if (loopString != null) return loopString;

        //Multiple CEO case
        if (ceos.size() > 1) {
            return "Multiple CEOs found: " + formatString(ceos);
        }

        return "The company structure is valid";
    }

    private static String checkLoops(Set<String> cycles, Map<String, String> employees, Set<String> ceos) {
        if (cycles.size() > 1) {
            boolean selfLoop = true;
            for (String cycleElem : cycles) {
                selfLoop = selfLoop && (cycles.contains(employees.get(cycleElem)));
            }
            if (selfLoop)
                return getSingleCycle(cycles, employees);
            return "Multiple loops were detected";
        } else if (cycles.size() == 1) {
            return getSingleCycle(cycles, employees);
        }
        return null;
    }

    private static String getSingleCycle(Set<String> cycles, Map<String, String> employees) {
        String entryPoint = cycles.iterator().next();
        Set<String> empCycle = new TreeSet<>();
        String tempEmployee = employees.get(entryPoint);
        empCycle.add(tempEmployee);
        while (!entryPoint.equals(tempEmployee)) {
            empCycle.add(employees.get(tempEmployee));
            tempEmployee = employees.get(tempEmployee);
        }
        empCycle.add(tempEmployee);

        return "A loop was detected involving: " + formatString(empCycle);
    }

    /**
     * Accepts a Set<String> and returns the comma separated string
     */
    private static String formatString(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        set.forEach(v -> sb.append(v).append(", "));
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
}
