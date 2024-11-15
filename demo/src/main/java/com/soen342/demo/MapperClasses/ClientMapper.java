package com.soen342.demo.MapperClasses;

import com.soen342.demo.IdentityClasses.ClientIdentity;
import com.soen342.demo.dto.ClientDto;

public class ClientMapper {
    public static ClientDto mapToClientDto(ClientIdentity client) {
        return new ClientDto(
            client.getClient_id(),
            client.getAge(),
            client.getFirstName(),
            client.getLastName(),
            client.getPhoneNumber(),
            client.getPassword(),
            client.getGuardianPhoneNumber()
        );
    }

    public static ClientIdentity mapToClientIdentity(ClientDto clientDto) {
        return new ClientIdentity(
            clientDto.getClient_id(),
            clientDto.getAge(),
            clientDto.getFirstName(),
            clientDto.getLastName(),
            clientDto.getPhoneNumber(),
            clientDto.getPassword(),
            clientDto.getGuardianPhoneNumber()
        );
    }
}
