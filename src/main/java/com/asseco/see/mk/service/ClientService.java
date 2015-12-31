package com.asseco.see.mk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asseco.see.mk.model.Client;
import com.asseco.see.mk.repository.ClientRepository;

@Service
@Transactional
public class ClientService implements IClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	public Client findClient(Long id) {
		return clientRepository.findOne(id);
	}

	public void saveClient(Client client) {
		clientRepository.save(client);
	}

}
