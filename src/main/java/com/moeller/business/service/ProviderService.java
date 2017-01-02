package com.moeller.business.service;

import com.moeller.business.dao.ProviderRepository;
import com.moeller.business.domain.Provider;
import com.moeller.business.messaging.JmsMsg;
import com.moeller.common.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created by Bernd on 25.12.2016.
 */
@Service
@Transactional
public class ProviderService {

    private ProviderRepository providerRepository;

    private JmsMsg jmsMsg;

    protected ProviderService(){}

  @Inject
  public ProviderService(ProviderRepository providerRepository, JmsMsg jmsMsg) {
    this.providerRepository = providerRepository;
    this.jmsMsg = jmsMsg;
  }


  public void saveProvider(Provider provider){
        providerRepository.saveProvider(provider);
        jmsMsg.sendMessage(provider);
    }
}
