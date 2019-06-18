package com.new_buildings.services.impl;

import com.new_buildings.command.AddressCommand;
import com.new_buildings.converters.AddressCommandToAddress;
import com.new_buildings.converters.AddressToAddressCommand;
import com.new_buildings.dao.interfaces.AddressDAO;
import com.new_buildings.entities.Address;
import com.new_buildings.services.interfaces.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressDAO addressDAO;
    private final AddressCommandToAddress addressCommandToAddress;
    private final AddressToAddressCommand addressToAddressCommand;

    public AddressServiceImpl(AddressDAO addressDAO, AddressCommandToAddress addressCommandToAddress, AddressToAddressCommand addressToAddressCommand) {
        this.addressDAO = addressDAO;
        this.addressCommandToAddress = addressCommandToAddress;
        this.addressToAddressCommand = addressToAddressCommand;
    }

    @Transactional
    public AddressCommand findCommandById(Long id) {
        Address detachedAddress = addressDAO.findCommandById(id);
        return addressToAddressCommand.convert(detachedAddress);
    }

    @Override
    public AddressCommand saveAddressCommand(AddressCommand object) {
        Address detachedAddress = addressCommandToAddress.convert(object);
        Address savedAddress = addressDAO.saveAddressCommand(detachedAddress);
        return addressToAddressCommand.convert(savedAddress);
    }

    @Override
    public List<Address> findAll() {
        List<Address> addresses = addressDAO.findAll();
        return addresses;
    }

    @Transactional
    public Address findById(Long aLong) {
        Address address = addressDAO.findById(aLong);
        return address;
    }

    @Override
    public Address save(Address object) {
        return null;
    }

    @Override
    public void delete(Address object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
