package com.nttdata.bank.client.service.impl;

import com.nttdata.bank.client.service.ClientService;
import com.nttdata.bank.client.model.Client;
import com.nttdata.bank.client.model.ClientDto;
import com.nttdata.bank.client.repository.ClientRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private Mapper mapper;


  @Override
  public Flux<Client> getAll() {
      System.out.println("Listando todos los cliente");
    return clientRepository
        .findAll()
        .switchIfEmpty(Flux.empty());
  }

  @Override
  public Mono<Client> save(ClientDto clientDto) {
      System.out.println("Guardando cliente");
    return clientRepository
        .existsById(clientDto.getClientId())
        .flatMap((isExist -> {
          if (!isExist) {
            return clientRepository.save(mapper.map(clientDto, Client.class));
          } else {
            return Mono.empty();
          }
        }));
  }

  @Override
  public Mono<Client> update(ClientDto clientDto) {
      System.out.println("Actualizando cliente");
    return clientRepository
        .existsById(clientDto.getClientId())
        .flatMap((isExist -> {
          if (isExist) {
            return clientRepository.save(mapper.map(clientDto, Client.class));
          } else {
            return Mono.empty();
          }
        }));
  }

  @Override
  public Mono<Void> delete(Integer clientId) {
      System.out.println("Eliminando cliente por id");
    return clientRepository
        .findById(clientId)
        .flatMap(p -> clientRepository.deleteById(clientId))
        .switchIfEmpty(Mono.empty());
  }

  @Override
  public Mono<Client> findById(Integer clientId) {
      System.out.println("Listando cliente por id");
    return clientRepository.
        findById(clientId);
  }

    @Override
    public Flux<Client> findByCodProfile(String codProfile) {
        System.out.println("Listando clientes por perfil digitado");
        return clientRepository.findByCodProfile(codProfile);
    }
}
