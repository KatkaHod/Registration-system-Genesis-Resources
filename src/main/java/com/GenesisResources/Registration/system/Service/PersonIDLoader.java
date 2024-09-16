package com.GenesisResources.Registration.system.Service;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

@Service
public class PersonIDLoader {
    private Queue<String> personIDs;

    public PersonIDLoader() throws IOException {
        personIDs = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getResourceAsStream("/dataPersonId.txt"))))) {
            String line;
            while ((line = reader.readLine()) != null) {
                personIDs.add(line.trim());
            }
        }
    }

    public String getNextPersonID() {
        if (personIDs.isEmpty()) {
            throw new RuntimeException("No more PersonIDs available.");
        }
        return personIDs.poll();
    }


}
