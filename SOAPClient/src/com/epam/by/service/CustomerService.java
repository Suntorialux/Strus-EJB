/**
 * CustomerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.epam.by.service;

public interface CustomerService extends java.rmi.Remote {
    public void deleteCustomer(int arg0) throws java.rmi.RemoteException;
    public void addCustomer(com.epam.by.service.AddCustomerArg0 arg0) throws java.rmi.RemoteException;
    public com.epam.by.service.GetAllCustomersResponseReturnCustomer[] getAllCustomers() throws java.rmi.RemoteException;
    public com.epam.by.service.GetCustomerByIdResponseReturn getCustomerById(int arg0) throws java.rmi.RemoteException;
    public void updateCustomer(com.epam.by.service.UpdateCustomerArg0 arg0) throws java.rmi.RemoteException;
}
