/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.customers.domain.service;
import co.unicauca.customers.domain.entity.Customer;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import co.unicauca.customers.access.ICustomerRepository;

@RequestScoped
public class CustomerService {

 @Inject
 @Default
 ICustomerRepository repo;
 public CustomerService() {
 }

 public List<Customer> findAll() {
 return repo.findAll();
 }
 
 public Customer findById(int id) {
 return repo.findById(id);
 }
 public boolean create(Customer prod) {
 return repo.create(prod);
 }
 public boolean update(Customer prod) {
 return repo.update(prod);
 }
 public boolean delete(int id) {
 return repo.delete(id);
 }
}
