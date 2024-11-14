package com.soen342.demo.ServiceInterfaces;

import com.soen342.demo.dto.ClientDto;

public interface ClientService {
    ClientDto createClient(ClientDto clientDto);
    ClientDto getClientById(int id);
    ClientDto updateClient(int id, ClientDto clientDto);
    void deleteClient(int id);
}
