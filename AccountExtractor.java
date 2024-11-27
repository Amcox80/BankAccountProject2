package model;

import model.ImportXMLFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;

public class AccountExtractor {

public List<Map<String, String>> accountsExtracted(String contentsOfFile) {

    List<Map<String, String>> formattedRequests = new ArrayList<>();

    try {
        if (contentsOfFile == null) {
            System.out.println("Invalid input");
            throw new IOException();
        }
        List<String> rawRequests = contentsOfFile.lines().collect(Collectors.toList());

        Map<String, String> individualRequests = new HashMap<>();

        for (int i = 0; i < rawRequests.size(); i++) {

            if (rawRequests.get(i).contains("firstname")) {
                individualRequests.put("firstname", rawRequests.get(i));
            }

            if (rawRequests.get(i).contains("email")) {
                individualRequests.put("email", rawRequests.get(i));
            }

            if (rawRequests.get(i).contains("phone")) {
                individualRequests.put("phone", rawRequests.get(i));
            }

            if (rawRequests.get(i).contains("location")) {
                individualRequests.put("location", rawRequests.get(i));
            }

            // Xml file segmemts always end in </request>.
            if (rawRequests.get(i).contains("</request>")) {
                formattedRequests.add(new HashMap<>(individualRequests));
                individualRequests.clear();
            }
        }
    }
    catch (IOException exception) {
        System.out.println("error " + exception.getMessage());
    }

    return formattedRequests;

    }

}

