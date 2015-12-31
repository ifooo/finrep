package com.asseco.see.mk.service;

import java.util.List;

import com.asseco.see.mk.model.Client;

public interface IClientService {

	List<Client> getClients();

	Client findClient(Long id);

	void saveClient(Client client);

}
