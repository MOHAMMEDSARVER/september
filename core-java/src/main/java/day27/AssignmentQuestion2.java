package day27;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AssignmentQuestion2 {

    public static void main(String[] args) {

        List<String> CS = List.of("KVR", "NVR", "GVR", "ALN", "PKM", "MKR");
        List<String> IS = List.of("KVR", "NVR", "KRS", "TRS", "MKR");
        List<String> EC = List.of("KVR", "NVR", "MVG", "MDG", "MKR");

        // All unique names from all the lists

        Set<String> uniquelists = new HashSet<>();
        uniquelists.addAll(CS);
        uniquelists.addAll(IS);
        uniquelists.addAll(EC);
        System.out.println("Unique List:  " + uniquelists);

        // Get names who are working in all the departments
        List<String> list = CS.stream()
                .filter(e -> IS.contains(e))
                .filter(e -> CS.contains(e))
                .toList();
        System.out.println("Names available in all the list: " + list);

        // Get names who are working for only one department

       Set<String> onedept=new HashSet<>();
       uniquelists.forEach(e->{
           if(CS.contains(e) && !IS.contains(e) && !EC.contains(e))
               onedept.add(e);
           else if (!CS.contains(e) && IS.contains(e) && !EC.contains(e))
               onedept.add(e);
           else if (!CS.contains(e) && !IS.contains(e) && EC.contains(e))
               onedept.add(e);
       });
        System.out.println("One dept names:" + onedept);

    }

}
