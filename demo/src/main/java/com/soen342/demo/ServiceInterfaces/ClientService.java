package com.soen342.demo.ServiceInterfaces;

import java.util.List;

import com.soen342.demo.dto.ClientDto;

public interface ClientService {
    ClientDto createClient(ClientDto clientDto);
    ClientDto getClientById(int id);
    ClientDto updateClient(int id, ClientDto clientDto);
    void deleteClient(int id);
    List<ClientDto> getAllClients();
}
