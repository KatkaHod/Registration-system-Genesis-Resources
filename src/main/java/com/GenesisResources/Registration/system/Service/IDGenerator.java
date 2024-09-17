package com.GenesisResources.Registration.system.Service;

import org.springframework.stereotype.Service;

@Service
public class IDGenerator {
    private int currentId = 1;

    public synchronized int generateId() {
        return currentId++;
    }
}
