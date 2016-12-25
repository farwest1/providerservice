package com.moeller.business.dao;

import com.moeller.business.domain.Permission;
import com.moeller.business.domain.Provider;
import com.moeller.rest.dto.PermissionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bernd on 27.08.2016.
 */
@ApplicationScoped
@Transactional
public class ProviderRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProviderRepository.class);

    @PersistenceContext(unitName = "primary")
    EntityManager entityManager;

    public Provider findProviderById(long id){

        LOGGER.debug("Find provider with id " + id);
        Provider provider = entityManager.find(Provider.class, id);

        return provider;
    }

    public void saveProvider (Provider provider){

        entityManager.persist(provider);
    }




    public List<PermissionDto> findPermissions(){
        List<PermissionDto> permissionDtoList = new ArrayList<PermissionDto>();
        permissionDtoList.add(new PermissionDto(1,"Perm1"));
        permissionDtoList.add(new PermissionDto(2,"Perm2"));

        return permissionDtoList;
    }
}
