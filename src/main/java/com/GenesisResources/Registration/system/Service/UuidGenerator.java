package com.GenesisResources.Registration.system.Service;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UuidGenerator {
    public String generateUuid() {
        return UUID.randomUUID().toString();
    }

}
