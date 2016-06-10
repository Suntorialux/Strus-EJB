package com.epam.by.service;

public class CustomerServiceProxy implements com.epam.by.service.CustomerService {
  private String _endpoint = null;
  private com.epam.by.service.CustomerService customerService = null;
  
  public CustomerServiceProxy() {
    _initCustomerServiceProxy();
  }
  
  public CustomerServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCustomerServiceProxy();
  }
  
  private void _initCustomerServiceProxy() {
    try {
      customerService = (new com.epam.by.service.impl.CustomerServiceImplementationServiceLocator()).getCustomerServiceImplementationPort();
      if (customerService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)customerService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)customerService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (customerService != null)
      ((javax.xml.rpc.Stub)customerService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.epam.by.service.CustomerService getCustomerService() {
    if (customerService == null)
      _initCustomerServiceProxy();
    return customerService;
  }
  
  public void deleteCustomer(int arg0) throws java.rmi.RemoteException{
    if (customerService == null)
      _initCustomerServiceProxy();
    customerService.deleteCustomer(arg0);
  }
  
  public void addCustomer(com.epam.by.service.AddCustomerArg0 arg0) throws java.rmi.RemoteException{
    if (customerService == null)
      _initCustomerServiceProxy();
    customerService.addCustomer(arg0);
  }
  
  public com.epam.by.service.GetAllCustomersResponseReturnCustomer[] getAllCustomers() throws java.rmi.RemoteException{
    if (customerService == null)
      _initCustomerServiceProxy();
    return customerService.getAllCustomers();
  }
  
  public com.epam.by.service.GetCustomerByIdResponseReturn getCustomerById(int arg0) throws java.rmi.RemoteException{
    if (customerService == null)
      _initCustomerServiceProxy();
    return customerService.getCustomerById(arg0);
  }
  
  public void updateCustomer(com.epam.by.service.UpdateCustomerArg0 arg0) throws java.rmi.RemoteException{
    if (customerService == null)
      _initCustomerServiceProxy();
    customerService.updateCustomer(arg0);
  }
  
  
}