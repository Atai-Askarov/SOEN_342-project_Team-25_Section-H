package com.soen342.demo.ServiceInterfaces;

import org.springframework.stereotype.Service;
import com.soen342.demo.IdentityClasses.ClientIdentity;
import com.soen342.demo.MapperClasses.ClientMapper;
import com.soen342.demo.RepositoryClasses.ClientRepository;
import com.soen342.demo.dto.ClientDto;
import com.soen342.demo.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        ClientIdentity client = ClientMapper.mapToClientIdentity(clientDto);
        ClientIdentity savedClient = clientRepository.save(client);
        return ClientMapper.mapToClientDto(savedClient);
    }

    @Override
    public ClientDto getClientById(int id) {
        ClientIdentity client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client does not exist with the given ID"));
        return ClientMapper.mapToClientDto(client);
    }

    @Override
    public ClientDto updateClient(int id, ClientDto clientDto) {
        ClientIdentity existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client does not exist with the given ID"));
        
        existingClient.setAge(clientDto.getAge());
        existingClient.setFirstName(clientDto.getFirstName());
        existingClient.setLastName(clientDto.getLastName());
        existingClient.setPhoneNumber(clientDto.getPhoneNumber());
        existingClient.setPassword(clientDto.getPassword());
        existingClient.setGuardianPhoneNumber(clientDto.getGuardianPhoneNumber());

        ClientIdentity updatedClient = clientRepository.save(existingClient);
        return ClientMapper.mapToClientDto(updatedClient);
    }

    @Override
    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }
}
